package com.spdb.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Payment
 * @Author: DELL
 * @Date: 2020/12/27 16:56
 * @Description: 支付实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private  String serial;
}
