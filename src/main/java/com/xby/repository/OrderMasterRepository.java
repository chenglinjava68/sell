package com.xby.repository;

import com.xby.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author :xby
 * @date :2019/1/25 12:29
 * @description :
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    //根据买家openid查询订单，并分页
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
