package com.github.tricks.advice;

import com.github.tricks.annotation.AuditLog;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * \@within(annotationType) 匹配带有指定注解的类（注：与上不同）
 *
 * @author 石少东
 * @date 2020-10-14 20:14
 * @since 1.0
 */

@Slf4j
@Aspect
@Component
public class AuditLogAdvice {

    @Pointcut("@annotation(auditLog)")
    public void pointcut(AuditLog auditLog) {
    }

    @Around(value = "pointcut(auditLog)")
    @SneakyThrows(Throwable.class)
    public Object log(@NotNull ProceedingJoinPoint pjp, @NotNull AuditLog auditLog) {
        log.info("AuditLog - {}", auditLog.value());
        return pjp.proceed();
    }

}
