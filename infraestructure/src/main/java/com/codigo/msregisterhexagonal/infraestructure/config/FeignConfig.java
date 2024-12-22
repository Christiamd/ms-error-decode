package com.codigo.msregisterhexagonal.infraestructure.config;

import com.codigo.msregisterhexagonal.infraestructure.rest.CustomErrorDecoder;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public CustomErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }

}
