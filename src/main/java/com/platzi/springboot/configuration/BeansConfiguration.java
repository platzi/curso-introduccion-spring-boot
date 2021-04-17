package com.platzi.springboot.configuration;

import com.platzi.springboot.bean.MyOperation;
import com.platzi.springboot.bean.implementation.MyOperationImpl;
import com.platzi.springboot.services.BeanWithDependencies;
import com.platzi.springboot.services.MyBeanWithDependenciesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    @Bean
    public BeanWithDependencies beanWithDependencies(MyOperation myOperation) {
        return new MyBeanWithDependenciesImpl(myOperation);
    }

    @Bean
    public MyOperation beanOperation() {
        return new MyOperationImpl();
    }
}
