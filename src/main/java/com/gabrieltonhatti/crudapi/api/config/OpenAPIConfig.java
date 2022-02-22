package com.gabrieltonhatti.crudapi.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Gabriel Tonhatti Cardoso");
        contact.setEmail("gabrieltonhatti37@gmail.com");
        contact.setUrl("https://www.linkedin.com/in/gabriel-tonhatti-2480561b9/");

        return new OpenAPI()
                .info(new Info()
                        .title("CRUD API")
                        .description("Documentação da API Restful")
                        .version("1.0.0")
                        .contact(contact)
                );
    }

}
