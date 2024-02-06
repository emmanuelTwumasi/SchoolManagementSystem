package com.emmanueltwumasi.schoolmanagementsystem.config.openapi_config;


import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

;import java.util.Optional;

@Configuration
//@OpenAPIDefinition(info = @Info(title = "School Management Api", version = "1.0.0"))
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(securitySchemes())
                .info(ApiInfo());
    }

    private static Components securitySchemes() {
        return new Components()
                .addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"));
    }

    private static Info ApiInfo() {
        return new Info()
                .title("School Management API")
                .description("Rest API of the School Management application. It contains CRUD functionalities.")
                .contact(new Contact()
                        .name("Developer: Emmanuel Twumasi")
                        .url("https://github.com/emmanueltwumasi"));
    }
}

