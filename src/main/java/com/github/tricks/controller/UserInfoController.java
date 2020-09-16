package com.github.tricks.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.tricks.pojo.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-09-16 21:53
 * @since 1.0
 */


@Slf4j
@RestController
public class UserInfoController {

    @PostMapping("/user")
    @JsonView(UserInfoDTO.IUserResponseView.class)
    public UserInfoDTO user(@JsonView(UserInfoDTO.IUserRequestView.class) @RequestBody UserInfoDTO user) {
        System.out.println(user.toString());
        return user;
    }


}
