package com.github.tricks.runner;

import com.github.tricks.manager.IUserManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 石少东
 * @date 2020-10-14 16:46
 * @since 1.0
 */

@Component
public class Runner implements CommandLineRunner {

    @Resource
    private Map<String, IUserManager> map;

    private final List<IUserManager> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        list.addAll(map.values());
        AnnotationAwareOrderComparator.sort(list);
    }

    @Override
    public void run(String... args) throws Exception {
        list.forEach(IUserManager::print);
    }
}
