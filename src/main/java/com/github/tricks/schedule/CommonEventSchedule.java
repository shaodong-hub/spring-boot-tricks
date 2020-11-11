package com.github.tricks.schedule;

import com.github.tricks.event.CommonEvent;
import com.github.tricks.pojo.DataBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 石少东
 * @date 2020-11-11 13:05
 * @since 1.0
 */


@Slf4j
@Component
public class CommonEventSchedule {

    @Resource
    private ApplicationContext applicationContext;

    @Scheduled(fixedDelay = 1000)
    public void eventSchedule() {
        applicationContext.publishEvent(new CommonEvent(this, new DataBO(new Date().toString())));
    }

}
