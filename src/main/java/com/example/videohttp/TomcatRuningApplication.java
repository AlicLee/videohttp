package com.example.videohttp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


public class TomcatRuningApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(VideohttpApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VideohttpApplication.class);
    }


}
