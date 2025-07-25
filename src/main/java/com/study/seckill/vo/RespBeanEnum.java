////公共返回对象枚举，存放状态
//package com.study.seckill.vo;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.ToString;
//
//@Getter
//@ToString
//@AllArgsConstructor
//public enum RespBeanEnum {
//    SUCCESS(200,"SUCCESS"),
//    ERROR(500,"服务端异常");
//
//    private final Integer code;
//    private final String message;

// 手动添加私有构造器
//    RespBeanEnum(Integer code, String message) {
//        this.code = code;
//        this.message = message;
//    }
//}

//区别在于有没有注解@AllArgsConstructor
package com.study.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),
//    登录5001xx
    LOGIN_ERROR(500210,"用户名或密码不正确"),
    MOBILE_ERROR(500211,"号码格式不正确"),
    BIND_ERROR(500212,"参数校验异常"),
    MOBILE_NOT_EXIST(500213,"手机号码不存在"),
    PASSWORD_UPDATE_FAIL(500214,"更新密码失败"),
    SESSION_ERROR(500215,"用户不存在"),
//    秒杀模块5005xx
    EMPTY_STOCK(500500,"库存不足"),
    REPEATE_ERROR(500501,"该商品限购一件"),
//    订单模块5003xx
    ORDER_NOT_EXIST(500300,"订单信息不存在"),



    ;
    private final Integer code;
    private final String message;

}