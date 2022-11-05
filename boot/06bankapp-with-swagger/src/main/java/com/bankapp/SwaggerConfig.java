package com.bankapp;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "ChampBank API", version = "2.6" , description = "ChampBank bankapp API"))
public class SwaggerConfig {

}
