package com.github.tricks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class SpringBootTricksApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootTricksApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringBootTricksApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

}
