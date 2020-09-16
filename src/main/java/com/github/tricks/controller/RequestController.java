package com.github.tricks.controller;

import com.github.tricks.pojo.UserInfoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-09-16 21:12
 * @since 1.0
 */

@RestController
public class RequestController {

    @PostMapping("user")
    public UserInfoDTO user(@RequestBody UserInfoDTO user) {
        return user;
    }


}
