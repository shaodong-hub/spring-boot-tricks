package com.github.tricks.manager.impl;

import com.github.tricks.manager.IUserManager;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author 石少东
 * @date 2020-10-14 16:44
 * @since 1.0
 */

@Order(2)
@Service
public class UserManager2Impl implements IUserManager {

    @Override
    public void print() {
        System.out.println(this.getClass().getName());
    }
}
