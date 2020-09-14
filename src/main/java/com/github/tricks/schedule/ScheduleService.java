package com.github.tricks.schedule;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 石少东
 * @date 2020-09-08 09:30
 * @since 1.0
 */

@Slf4j
@Component
public class ScheduleService {

    private static final String LOCK_TIME = "100s";

    @Scheduled(fixedDelay = 5000)
    @SchedulerLock(name = "myTask1", lockAtMostFor = LOCK_TIME, lockAtLeastFor = LOCK_TIME)
    public void task1() throws Exception {
        TimeUnit.SECONDS.sleep(50);
        log.info("myTask1 - {}", Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 5000)
    @SchedulerLock(name = "myTask2", lockAtMostFor = LOCK_TIME, lockAtLeastFor = LOCK_TIME)
    public void task2() throws Exception {
        TimeUnit.SECONDS.sleep(50);
        log.info("myTask2 - {}", Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 5000)
    @SchedulerLock(name = "myTask3", lockAtMostFor = LOCK_TIME, lockAtLeastFor = LOCK_TIME)
    public void task3() throws Exception {
        TimeUnit.SECONDS.sleep(50);
        log.info("myTask3 - {}", Thread.currentThread().getName());
    }

}
