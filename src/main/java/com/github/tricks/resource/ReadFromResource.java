package com.github.tricks.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tricks.pojo.CountryBO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author 石少东
 * @date 2020-09-07 16:58
 * @since 1.0
 */


@Component
@RequiredArgsConstructor
public class ReadFromResource {

    @Value("classpath:static/country.json")
    private Resource resource;

    private final ObjectMapper objectMapper;

    @PostConstruct
    public void init() throws Exception {
        List<CountryBO> list = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<CountryBO>>() {
        });
        list.forEach(System.out::println);
    }

}
