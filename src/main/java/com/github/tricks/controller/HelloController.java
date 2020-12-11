package com.github.tricks.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-12-10 09:36
 * @since 1.0
 */

@RestController
public class HelloController {

    @Value("${value}")
    private String value;

    @GetMapping("/hello")
    public String hello() {
        return "hello" + value;
    }

}
