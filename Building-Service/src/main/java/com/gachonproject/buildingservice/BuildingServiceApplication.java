package com.gachonproject.buildingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BuildingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingServiceApplication.class, args);
    }

}
