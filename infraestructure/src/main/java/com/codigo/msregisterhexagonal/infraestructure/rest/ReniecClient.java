package com.codigo.msregisterhexagonal.infraestructure.rest;

import com.codigo.msregisterhexagonal.domain.aggregates.response.ResponseReniec;
import com.codigo.msregisterhexagonal.infraestructure.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniec-client", url = "https://api.apis.net.pe/v2/sunat",configuration = FeignConfig.class)
public interface ReniecClient {

    @GetMapping("/ruc/full")
    ResponseReniec getInfoReniec(@RequestParam("numero") String numero,
                                 @RequestHeader("Authorization") String token);
}
