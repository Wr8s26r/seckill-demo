package com.study.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@EqualsAndHashCode(callSuper = false)
@Data
public class User implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID，手机号码
     */
    @TableId
    private Long id;

    /**
     *
     */
    private String nickname;

    /**
     * MD5(MD5(pass明文+固定salt)+salt)
     */
    private String password;

    /**
     *
     */
    private String salt;

    /**
     * 头像
     */
    private String head;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;

}
