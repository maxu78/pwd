package com.fiberhome.pwd.test;

import com.fiberhome.pwd.pojo.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestCondition {

    @Bean
    public User getUser() {
        return new User();
    }

    @ConditionalOnBean(name = {"getUser"})
    @Bean
    public String test() {
        System.out.println("test............");
        return "test";
    }
}
