package com.gachonproject.userservice.global.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@OpenAPIDefinition
//@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(@Value("${openapi.service.url}") String url) {
        return new OpenAPI()
                .addServersItem(new Server().url(url))
                .info(apiInfo());
    }


    private Info apiInfo() {
        return new Info()
                .title("User-Service API Specifications")
                .description("User-Service API 스웨거 명세서")
                .version("1.0.0");
    }
}
