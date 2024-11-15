package com.uber_persona.backend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiSpec() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                        .addSchemas("ApiErrorResponse", new ObjectSchema()
                                .addProperty("status", new IntegerSchema())
                                .addProperty("code", new Schema<String>().type("string"))
                                .addProperty("message", new Schema<String>().type("string"))
                                .addProperty("fieldErrors", new ArraySchema()
                                        .items(new ObjectSchema()
                                                .addProperty("code", new Schema<String>().type("string"))
                                                .addProperty("message", new Schema<String>().type("string"))
                                                .addProperty("property", new Schema<String>().type("string"))
                                                .addProperty("rejectedValue", new ObjectSchema())
                                                .addProperty("path", new Schema<String>().type("string")))))
                )
                .info(new io.swagger.v3.oas.models.info.Info().title("API Example").version("1.0"));
    }

    @Bean
    public OperationCustomizer operationCustomizer() {
        return (operation, handlerMethod) -> {
            operation.getResponses()
                    .addApiResponse("400", new ApiResponse()
                            .description("Bad Request")
                            .content(new Content().addMediaType("application/json", new MediaType().schema(
                                    new Schema<>().$ref("ApiErrorResponse")))))
                    .addApiResponse("404", new ApiResponse()
                            .description("Not Found")
                            .content(new Content().addMediaType("application/json", new MediaType().schema(
                                    new Schema<>().$ref("ApiErrorResponse")))))
                    .addApiResponse("500", new ApiResponse()
                            .description("Internal Server Error")
                            .content(new Content().addMediaType("application/json", new MediaType().schema(
                                    new Schema<>().$ref("ApiErrorResponse")))))
                    .addApiResponse("default", new ApiResponse()
                            .description("Generic Error")
                            .content(new Content().addMediaType("application/json", new MediaType().schema(
                                    new Schema<>().$ref("ApiErrorResponse")))));
            return operation;
        };
    }
}
