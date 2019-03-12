package com.fiberhome.pwd.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${jwt.route.authentication.path}")
    private String login;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(login).setViewName("login");
    }
}
