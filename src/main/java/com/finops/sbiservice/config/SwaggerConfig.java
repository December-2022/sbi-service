package com.finops.sbiservice.config;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.*;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //students
    @Bean
    public Docket leaveAPi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(studentAPIInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/.*"))
                .build();
//                        securitySchemes(Arrays.asList(basicAuth()));
    }

    private Predicate<String> LeavePaths() {
        return Predicates.or(

                regex("/api/.*"),
                regex("/api/.*"));
    }

}




