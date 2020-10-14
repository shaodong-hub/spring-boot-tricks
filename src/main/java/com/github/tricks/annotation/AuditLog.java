package com.github.tricks.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 石少东
 * @date 2020-10-14 20:11
 * @since 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuditLog {
    String value() default "AuditLog";

}
