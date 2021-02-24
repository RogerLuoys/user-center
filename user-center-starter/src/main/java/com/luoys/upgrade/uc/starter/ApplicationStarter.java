package com.luoys.upgrade.uc.starter;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.luoys.upgrade.uc"})
@MapperScan("com.luoys.upgrade.uc.dao")
@EnableDubbo(scanBasePackages = {"com.luoys.upgrade.uc.service.impl"})
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
