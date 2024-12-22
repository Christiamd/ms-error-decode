package com.codigo.msregisterhexagonal.infraestructure.adapters;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // Puedes verificar el código de estado HTTP y tomar decisiones sobre cómo manejar los errores
        if (response.status() == HttpStatus.BAD_REQUEST.value()) {
            return new RuntimeException("Error de solicitud incorrecta: " + response.request().url());
        }
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return new RuntimeException("Recurso no encontrado: " + response.request().url());
        }
        if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return new RuntimeException("Error interno del servidor: " + response.request().url());
        }

        // Maneja otros casos de error según sea necesario
        return new Exception("Error desconocido: " + response.status());
    }
}
