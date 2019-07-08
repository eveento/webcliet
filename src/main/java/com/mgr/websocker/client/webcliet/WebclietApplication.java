package com.mgr.websocker.client.webcliet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties
@EnableScheduling
public class WebclietApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebclietApplication.class, args);
    }

}
