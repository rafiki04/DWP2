package com.product.config.openapi;

import java.util.TreeMap;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;

@Configuration
public class CustomOpenAPI {

   
    @Bean
    public OpenAPI customopenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Product")
                        .version("1.0")
                        .description("API para la gestión de productos, categorías e imágenes"));
    }

   
    @Bean
    public OpenApiCustomizer sortPathsAndSchemas() {
        return openApi -> {

            Components components = openApi.getComponents();
            if (components != null && components.getSchemas() != null) {
                components.setSchemas(new TreeMap<>(components.getSchemas()));
            }

            
            Paths paths = openApi.getPaths();
            if (paths != null) {
                TreeMap<String, PathItem> sortedPaths = new TreeMap<>();
                paths.forEach(sortedPaths::put);
                Paths finalPaths = new Paths();
                sortedPaths.forEach(finalPaths::addPathItem);
                openApi.setPaths(finalPaths);
            }
        };
    }
}
