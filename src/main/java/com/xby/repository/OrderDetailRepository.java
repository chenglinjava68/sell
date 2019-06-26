package com.xby.repository;

import com.xby.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author :xby
 * @date :2019/1/25 13:03
 * @description :
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
        //根据订单id查询订单详情
        List<OrderDetail> findByOrderId(String orderId);

}

