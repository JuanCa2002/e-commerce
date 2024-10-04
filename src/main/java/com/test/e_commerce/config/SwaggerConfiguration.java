package com.test.e_commerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    private static final String SERVER_PORT = "2208";

    @Bean
    public OpenAPI springAccommodationOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("E-commerce management API")
                        .description("API that provides services for the management, administration and control of nexsys e-commerce")
                        .version("v0.0.1"))
                .servers(
                        List.of(
                                new Server().url("http://localhost:" + SERVER_PORT +"/nexsys/v1").description("API Gateway")
                        )
                );
    }
}
