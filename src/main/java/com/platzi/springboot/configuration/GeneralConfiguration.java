package com.platzi.springboot.configuration;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.bean.implementation.MyBeanTwoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    public MyBean myBean(){
        return new MyBeanTwoImpl();
    }

}
