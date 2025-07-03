//MD5工具类
package com.study.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component

public class MD5Utils {
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }
    private static final String salt = "1a2b3c4d";

    public static String inputPassToFromPass(String inputPass) {
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String fromPass,String salt) {
        String str = ""+salt.charAt(0)+salt.charAt(2)+fromPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass,String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass,salt);
        return dbPass;
    }

//    测试
//public static void main(String[] args) {
////    d3b1294a61a07da9b49b6e22b2cbd7f9第一次加密
//    System.out.println(inputPassToFromPass("123456"));
////    1897a69ef451f0991bb85c6e7c35aa31第二次加密
//    System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9","1a2b3c4d"));
////    1897a69ef451f0991bb85c6e7c35aa31存到数据库的密码
//    System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
//    }
}