package com.example.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yongchen
 */
@SpringBootApplication
@EnableEurekaClient
//@MapperScan("com.example.security.mapper")
public class IcSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcSecurityApplication.class, args);
    }

}
