package com.example.ms_producto;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class MsProductoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProductoApplication.class, args);
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OPEN API MICROSERVICIO PRODUCTO")
                        .description("Servicio web producto")
                        .version("1.0.0")
                );
    }


}
