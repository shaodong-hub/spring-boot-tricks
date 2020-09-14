package com.github.tricks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-09-11 16:49
 * @since 1.0
 */


@RestController
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index!";
    }

}
