package com.github.tricks.controller;

import com.github.tricks.pojo.DateTimeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-09-11 11:01
 * @since 1.0
 */
@Slf4j
@RestController
public class DateController {


    @PostMapping("date")
    public DateTimeDTO getDateTime(@RequestBody DateTimeDTO dateTime) {
        log.info(dateTime.toString());
        return dateTime;
    }


}
