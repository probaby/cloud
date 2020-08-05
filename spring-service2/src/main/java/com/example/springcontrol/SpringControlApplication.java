package com.example.springcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringControlApplication.class, args);
    }

}
