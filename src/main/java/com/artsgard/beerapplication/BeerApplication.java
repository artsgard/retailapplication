package com.artsgard.beerapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.properties"})
public class BeerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerApplication.class, args);
    }
}
