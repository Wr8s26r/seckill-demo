//公共返回对象
package com.study.seckill.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//成功返回结果
public class RespBean {

    private long code;
    private String message;
    private Object obj;


    //成功返回结果
    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),null);
    }
    public static RespBean success(Object obj) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBean.success().getMessage(),obj);
    }


    //失败返回结果
    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),null);
    }
    public static RespBean error(RespBeanEnum respBeanEnum, Object obj){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),obj);
    }
}
//package com.study.seckill.vo;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class RespBean {
//
//    private long code;
//    private String message;
//    private Object obj;
//
//    // 成功返回结果（直接使用 RespBeanEnum 的值）
//    public static RespBean success() {
//        return new RespBean(
//                RespBeanEnum.SUCCESS.getCode(),
//                RespBeanEnum.SUCCESS.getMessage(), // 直接使用枚举的 message
//                null
//        );
//    }
//
//    public static RespBean success(Object obj) {
//        return new RespBean(
//                RespBeanEnum.SUCCESS.getCode(),
//                RespBeanEnum.SUCCESS.getMessage(), // 直接使用枚举的 message
//                obj
//        );
//    }
//
//    // 失败返回结果
//    public static RespBean error(RespBeanEnum respBeanEnum) {
//        return new RespBean(
//                respBeanEnum.getCode(),
//                respBeanEnum.getMessage(),
//                null
//        );
//    }
//
//    public static RespBean error(RespBeanEnum respBeanEnum, Object obj) {
//        return new RespBean(
//                respBeanEnum.getCode(),
//                respBeanEnum.getMessage(),
//                obj
//        );
//    }
//}

