package com.example.videohttp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("com.example.videohttp.dao")
//@ComponentScan(basePackages = {"com.example.videohttp.service","com.example.videohttp.controller"})
public class VideohttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideohttpApplication.class, args);
    }

}
