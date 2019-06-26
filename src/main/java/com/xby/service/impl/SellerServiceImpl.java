package com.xby.service.impl;

import com.xby.dataobject.SellerInfo;
import com.xby.repository.SellerInfoRepository;
import com.xby.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :xby
 * @date :2019/2/8 10:15
 * @description :
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
