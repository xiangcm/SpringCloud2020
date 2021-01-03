package com.spdb.springcloud.controller;

import com.spdb.springcloud.entities.CommonResult;
import com.spdb.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Author: DELL
 * @Date: 2020/12/27 22:54
 * @Description: 订单模块controller
 **/
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment-service"; // 修改为服务注册中新服务提供者的服务名称

    /**
     * @Author xiangcm
     * @Description 创建订单
     * @Date 22:53 2020/12/27
     * @Param [payment]
     * @return com.spdb.springcloud.entities.CommonResult<com.spdb.springcloud.entities.Payment>
    **/
    @GetMapping("/consumer/payment/create")
    public CommonResult< Payment > create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    /**
     * @Author xiangcm
     * @Description 查询订单
     * @Date 22:53 2020/12/27
     * @Param [id]
     * @return com.spdb.springcloud.entities.CommonResult<com.spdb.springcloud.entities.Payment>
    **/
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult< Payment > getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
