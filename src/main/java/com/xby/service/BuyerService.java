package com.xby.service;

import com.xby.dto.OrderDTO;

/**
 * @author :xby
 * @date :2019/1/27 19:05
 * @description :
 */
public interface BuyerService {

    //查询订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
