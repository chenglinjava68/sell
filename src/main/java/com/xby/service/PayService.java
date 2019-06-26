package com.xby.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.xby.dto.OrderDTO;
import org.springframework.stereotype.Service;

/**
 * @author :xby
 * @date :2019/2/10 13:03
 * @description :
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
