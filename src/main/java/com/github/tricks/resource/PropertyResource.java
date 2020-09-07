package com.github.tricks.resource;

import com.github.tricks.pojo.CountryBO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-09-07 17:20
 * @since 1.0
 */

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "com.github.country")
@PropertySource(value = {"classpath:static/country.properties"})
public class PropertyResource {

    private Map<String, CountryBO> map;


    @PostConstruct
    public void init() {
        map.forEach((k, v) -> {
            System.out.print(k + "  ");
            System.out.println(v);
        });
    }


}
