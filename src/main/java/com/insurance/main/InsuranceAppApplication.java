package com.insurance.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.insurance.main") // Specify the base package(s) to scan
public class InsuranceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceAppApplication.class, args);
    }
}
