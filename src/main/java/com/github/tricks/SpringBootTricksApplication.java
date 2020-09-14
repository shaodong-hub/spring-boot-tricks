package com.github.tricks;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@EnableScheduling
@SpringBootApplication
public class SpringBootTricksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTricksApplication.class, args);
    }

}
