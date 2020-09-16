package com.github.tricks.annotation;

import com.github.tricks.encrypt.IEncrypt;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 石少东
 * @date 2020-09-16 21:24
 * @since 1.0
 */


@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Encrypt {

    String value() default " ";

    String key() default "";

}
