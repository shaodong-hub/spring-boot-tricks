package com.github.tricks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author 石少东
 * @date 2020-09-18 15:55
 * @since 1.0
 */


@RestController
public class IndexController {

    private final int a = new Random().nextInt(Integer.MAX_VALUE);

    @GetMapping("index")
    public String index() {
        return "hello - phoenix-waf-web - " + a + " \n" ;
    }

}
