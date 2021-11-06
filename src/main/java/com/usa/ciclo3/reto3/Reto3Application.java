package com.usa.ciclo3.reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan(basePackages = {"com.usa.ciclo3.reto3.model"})
//@ComponentScan("com.usa.ciclo3.reto3")
@SpringBootApplication
public class Reto3Application {

    public static void main(String[] args) {

        SpringApplication.run(Reto3Application.class, args);
    }

}
