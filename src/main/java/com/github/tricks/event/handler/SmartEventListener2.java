package com.github.tricks.event.handler;

import com.github.tricks.event.SmartEvent;
import com.github.tricks.schedule.SmartEventSchedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 石少东
 * @date 2020-11-11 13:19
 * @since 1.0
 */


@Slf4j
@Component
public class SmartEventListener2 implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        // 只接收 SmartEvent 类型的事件,只有 SmartEvent 类型的事件才会执行下面的逻辑
        return aClass == SmartEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        SmartEvent smartEvent = (SmartEvent) applicationEvent;
        System.out.println("-----------SmartEvent-2-----------");
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        //只有在 SmartEventSchedule 内发布的 SmartEvent 事件时才会执行下面逻辑
        return sourceType == SmartEventSchedule.class;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
