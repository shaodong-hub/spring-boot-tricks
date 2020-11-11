package com.github.tricks.event;

import com.github.tricks.pojo.DataBO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author 石少东
 * @date 2020-11-11 13:06
 * @since 1.0
 */



public class SmartEvent extends ApplicationEvent {

    private static final long serialVersionUID = -9104315091158790675L;

    @Getter
    private final DataBO data;

    public SmartEvent(Object source, DataBO data) {
        super(source);
        this.data = data;
    }

}
