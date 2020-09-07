package com.github.tricks.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * @author 石少东
 * @date 2020-09-04 14:31
 * @since 1.0
 */


@Slf4j
@Configuration
@EnableScheduling
public class TestSchedule {

    @Scheduled(cron = "0/10 * * * * ? ")
    @SneakyThrows(Exception.class)
    public void run1() {
        log.error("run1 - {}", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);

        throw new Exception("run1");
    }

    @Scheduled(cron = "0/10 * * * * ? ")
    @SneakyThrows(Exception.class)
    public void run2() {
        log.error("run2 - {}", Thread.currentThread().getName());
        throw new Exception("run2");
    }


}
