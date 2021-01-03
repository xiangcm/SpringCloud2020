package com.spdb.springcloud.controller;

import com.spdb.springcloud.entities.CommonResult;
import com.spdb.springcloud.entities.Payment;
import com.spdb.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PaymentController
 * @Author: DELL
 * @Date: 2020/12/27 17:50
 * @Description: 支付模块的Controller
 * 其中@Slf4j注解使用不报错，需要安装lombok插件
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient; // 引入服务发现
    /**
     * @Author xiangcm
     * @Description 创建支付单号
     * @Date 22:54 2020/12/27
     * @Param [payment]
     * @return com.spdb.springcloud.entities.CommonResult
    **/
    @PostMapping(value = "/payment/create")
    // 如果不写@RequestBody注解，使用消费者模块调用该方法插入时，serial=null，但返回的结果是插入成功。
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入的结果：{}",result);
        if(result > 0 ){
            return new CommonResult(200,"插入数据库成功！serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败！serverPort"+serverPort,null);
        }
    }

    /**
     * @Author xiangcm
     * @Description 查询支付单号
     * @Date 22:55 2020/12/27
     * @Param [id]
     * @return com.spdb.springcloud.entities.CommonResult
    **/
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(null != payment ){
            log.info("*********查询的结果：{}",payment);
            return new CommonResult(200,"查询成功！serverPort:"+serverPort,payment);
        }else {
            log.info("*********查询失败，查询id={}",id);
            return new CommonResult(444,"没有对应的记录,serverPort:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        // 获取服务注册中心上的服务名称
        List<String> services = discoveryClient.getServices();
        for (String service:  services ) {
            log.info("********service：{}",service);
        }
        // 获取服务注册中心上的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance:instances) {
            log.info("********instance-URI:{}",instance.getUri());
        }
        return this.discoveryClient;
    }
}
