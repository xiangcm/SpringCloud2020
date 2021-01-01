package com.spdb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: EurekaMain7001
 * @Author: DELL
 * @Date: 2020/12/29 22:45
 * @Description: Eureka服务注册中心启动类
 * *@EnableEurekaServer 注解生效必须导入eureka server依赖包
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
