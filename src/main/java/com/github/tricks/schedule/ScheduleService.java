package com.github.tricks.schedule;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 石少东
 * @date 2020-09-08 09:30
 * @since 1.0
 */

@Slf4j
@Component
public class ScheduleService {

    @Scheduled(fixedDelay = 5000)
    @SchedulerLock(name = "myTask1")
    public void task1() {
        log.info("myTask1 - {}", Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 5000)
    @SchedulerLock(name = "myTask2")
    public void task2() {
        log.info("myTask2 - {}", Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 5000)
    @SchedulerLock(name = "myTask3")
    public void task3() {
        log.info("myTask3 - {}", Thread.currentThread().getName());
    }

}
