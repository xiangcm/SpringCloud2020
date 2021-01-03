package com.spdb.springcloud.service.impl;

import com.spdb.springcloud.dao.PaymentDao;
import com.spdb.springcloud.entities.Payment;
import com.spdb.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentServiceImpl
 * @Author: DELL
 * @Date: 2020/12/27 17:47
 * @Description: TODO
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
