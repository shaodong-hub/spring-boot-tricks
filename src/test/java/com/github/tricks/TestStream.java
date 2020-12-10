package com.github.tricks;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 石少东
 * @date 2020-11-13 11:01
 * @since 1.0
 */


public class TestStream {

    @Test
    public void stream() {
        final AtomicInteger integer = new AtomicInteger(0);

        Stream<Integer> infiniteStream = Stream.generate(integer::getAndIncrement);
        infiniteStream.map(one -> one + 1)
                .collect(Collectors.toList())
                .forEach(one -> {
                    System.out.println(one);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        infiniteStream.map(one -> one + 1)
                .reduce(new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {

                        return null;
                    }
                });


    }
}
