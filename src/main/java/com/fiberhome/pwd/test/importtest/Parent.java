package com.fiberhome.pwd.test.importtest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Car.class, Plane.class})
public class Parent {
}
