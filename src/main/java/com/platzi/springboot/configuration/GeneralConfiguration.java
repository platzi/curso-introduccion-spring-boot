package com.platzi.springboot.configuration;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.bean.implementation.MyBeanTwoImpl;
import com.platzi.springboot.pojo.properties.UserProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserProperties.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.random}")
    private String randomValue;

    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String userName;
    @Value("${password}")
    private String password;


    @Bean
    public MyBean myBean() {
        return new MyBeanTwoImpl(name, randomValue);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

//    @Bean
//    public DataSource dataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:test");
//        dataSourceBuilder.username("SA");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//    }

}
