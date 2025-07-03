//验证手机号
package com.study.seckill.validator;

import com.study.seckill.vo.IsMobileValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//Target注解最后一个添加
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IsMobileValidation.class})

public @interface IsMobile {

    boolean required() default true;
    String message() default "手机号格式错误";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
//后两行添加
}
