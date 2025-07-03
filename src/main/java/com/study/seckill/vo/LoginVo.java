//登录参数
package com.study.seckill.vo;

import com.study.seckill.validator.IsMobile;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import org.hibernate.validator.constraints.Length;

@Data
public class LoginVo {
    @NotNull

    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
