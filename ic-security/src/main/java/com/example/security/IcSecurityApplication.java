package com.example.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yongchen
 */
@SpringBootApplication
@MapperScan("com.example.security.mapper")
public class IcSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcSecurityApplication.class, args);
    }

}
