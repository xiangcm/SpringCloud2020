package com.spdb.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CommonResult
 * @Author: DELL
 * @Date: 2020/12/27 16:58
 * @Description: 公共的前端返回结果类
 *  this(code, message, null); 不报错需要安装lombok插件
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
        private Integer code;
        private String message;
        private T data;
        public CommonResult(Integer code, String message) {
            this(code, message, null);
        }
}
