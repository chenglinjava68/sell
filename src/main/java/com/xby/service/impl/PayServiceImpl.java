package com.xby.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.xby.dto.OrderDTO;
import com.xby.enums.ResultEnum;
import com.xby.exception.SellException;
import com.xby.service.OrderService;
import com.xby.service.PayService;
import com.xby.utils.JsonUtil;
import com.xby.utils.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :xby
 * @date :2019/2/10 13:03
 * @description :
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    /**
     * 创建支付
     * @param orderDTO
     * @return
     */
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        //配置支付请求的信息
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付, request={}", JsonUtil.toJson(payRequest));
        //将支付所需信息传入pay()方法中唤起支付
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付, response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    /**
     * 异步通知商户支付结果
     * @param notifyData
     * @return
     */
    @Override
    public PayResponse notify(String notifyData) {
        //1. 验证签名，2. 支付的状态，3. 支付金额
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知, payResponse={}", JsonUtil.toJson(payResponse));
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());//查询订单
        if (orderDTO == null) {//判断订单是否存在
            log.error("【微信支付】异步通知, 订单不存在, orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //判断金额是否一致(0.10   0.1)
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知, 订单金额不一致, orderId={}, 微信通知金额={}, 系统金额={}",
                    payResponse.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }
        //修改订单的支付状态
        orderService.paid(orderDTO);
        return payResponse;
    }

    /**
     * 退款
     * @param orderDTO
     * @return
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】 request={}",JsonUtil.toJson(refundRequest));
        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】 response={}", JsonUtil.toJson(refundResponse   ));
        return refundResponse;
    }
}
