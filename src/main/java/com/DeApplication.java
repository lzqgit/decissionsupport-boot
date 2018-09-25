package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages ="com.phy.decisionsupport")
public class DeApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeApplication.class, args);
    }
}
