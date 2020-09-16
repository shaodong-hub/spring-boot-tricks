package com.github.tricks.config;

import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 石少东
 * @date 2020-09-16 14:28
 * @since 1.0
 */

@Component
public class LogbackFilter implements Filter {

    private static final String TEST_KEY = "test_key";

    private static int COUNT = 0;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, @NotNull FilterChain chain) throws IOException, ServletException {
        fillInfo((HttpServletRequest) request);
        chain.doFilter(request, response);
        clearAllInfo();
    }

    private void fillInfo(HttpServletRequest request) {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        MDC.put(TEST_KEY, COUNT++ + "");
    }

    private void clearAllInfo() {
        MDC.clear();
    }

}



