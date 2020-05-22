package org.luoys.uc.usercenterstarter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.luoys.uc"})
@MapperScan("com.luoys.uc.dao")
public class UserCenterStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterStarterApplication.class, args);
    }

}
