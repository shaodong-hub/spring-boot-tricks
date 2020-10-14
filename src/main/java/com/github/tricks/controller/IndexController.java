package com.github.tricks.controller;

import com.github.tricks.annotation.AuditLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-10-14 20:12
 * @since 1.0
 */


@RestController
public class IndexController {

    @GetMapping("/index1")
    public String index1(){
        return "index1";
    }

    @AuditLog
    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }

}
