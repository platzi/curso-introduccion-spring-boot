package com.platzi.springboot.configuration;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.bean.implementation.MyBeanTwoImpl;
import com.platzi.springboot.pojo.properties.UserProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.random}")
    private String randomValue;

    @Bean
    public MyBean myBean(){
        return new MyBeanTwoImpl(name, randomValue);
    }

}
