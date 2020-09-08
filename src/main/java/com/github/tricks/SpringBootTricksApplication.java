package com.github.tricks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class SpringBootTricksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTricksApplication.class, args);
    }

}
