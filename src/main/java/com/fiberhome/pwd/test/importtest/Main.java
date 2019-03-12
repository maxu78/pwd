package com.fiberhome.pwd.test.importtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Parent.class);
        Car car = (Car) context.getBean(Car.class);
        Plane plane = (Plane) context.getBean(Plane.class);
        car.run();plane.fly();
        context.close();
    }
}
