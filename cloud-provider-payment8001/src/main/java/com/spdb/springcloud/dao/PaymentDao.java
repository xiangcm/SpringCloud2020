package com.spdb.springcloud.dao;

import com.spdb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public  Payment getPaymentById(@Param("id") Long id);
}
