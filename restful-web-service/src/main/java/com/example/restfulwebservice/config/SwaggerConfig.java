package com.example.restfulwebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Contact DEFAULT_CONTACT = new Contact("Changeun",
            "naver.com","bce9238@naver.com");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("API title",
            "My user mangee rest api service","1.0","urn:tos",
            DEFAULT_CONTACT,"Aparche 2.0",
            "http://www.apache.org/license",new ArrayList<>());

    private static final Set<String> D = new HashSet<>(
            Arrays.asList("application/json","application/xml")
    );

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(D)
                .consumes(D);
    }
}
