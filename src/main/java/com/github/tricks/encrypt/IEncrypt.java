package com.github.tricks.encrypt;

/**
 * @author 石少东
 * @date 2020-09-16 21:28
 * @since 1.0
 */

@FunctionalInterface
public interface IEncrypt<T,E> {

    T encrypt(String key,E value) ;

}
