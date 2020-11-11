package com.github.tricks.event;

import com.github.tricks.pojo.DataBO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author 石少东
 * @date 2020-11-11 11:30
 * @since 1.0
 */


public class CommonEvent  extends ApplicationEvent {

    private static final long serialVersionUID = 6694932872503560843L;

    @Getter
    private final DataBO data;

    public CommonEvent(Object source, DataBO data) {
        super(source);
        this.data = data;
    }

}
