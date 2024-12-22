package com.codigo.msregisterhexagonal.infraestructure.rest;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String url = response.request().url();
        String message;
        System.out.println(response.status());
        switch (response.status()) {
            case 400:
                message = "Parametros incorrectos para el API manejado por errordecoder " + url;
                break;
            case 404:
                message = "No existe el RUC en " + url;
                break;
            case 500:
                message = "No se pudo procesar la petición manejado por errordecoder en " + url;
                break;
            case 422:
                message = "Error de api reniec que devuelve 422 unprocesable entity";
                break;
            default:
                message = "Error desconocido manejado por errordecoder: " + response.status() + " en " + url;
        }
        return new RuntimeException(message);
    }
}
