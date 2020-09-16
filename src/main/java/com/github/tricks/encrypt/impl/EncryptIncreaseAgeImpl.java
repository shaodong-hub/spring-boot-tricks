package com.github.tricks.encrypt.impl;

import com.github.tricks.encrypt.IEncrypt;
import org.springframework.stereotype.Component;

/**
 * @author 石少东
 * @date 2020-09-16 21:36
 * @since 1.0
 */

@Component
public class EncryptIncreaseAgeImpl implements IEncrypt<Integer, Integer> {

    @Override
    public Integer encrypt(String key, Integer value) {
        return null;
    }
}
