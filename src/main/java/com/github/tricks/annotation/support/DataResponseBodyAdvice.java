package com.github.tricks.annotation.support;

import com.github.tricks.annotation.Encrypt;
import com.github.tricks.encrypt.IEncrypt;
import com.github.tricks.pojo.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-09-16 21:21
 * @since 1.0
 */

@Slf4j
@RestControllerAdvice
public class DataResponseBodyAdvice implements ResponseBodyAdvice<UserInfoDTO> {

    @Resource
    private Map<String, IEncrypt<?, ?>> map;

    @Override
    public boolean supports(MethodParameter methodParameter, @NotNull Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.hasMethodAnnotation(Encrypt.class);
    }

    @Override
    public UserInfoDTO beforeBodyWrite(UserInfoDTO userInfoDTO, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Encrypt encrypt = methodParameter.getMethodAnnotation(Encrypt.class);


        return null;
    }
//    @Override
//    public boolean supports(@org.jetbrains.annotations.NotNull MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        return methodParameter.hasMethodAnnotation(Encrypt.class);
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//
//
//        return null;
//    }
}
