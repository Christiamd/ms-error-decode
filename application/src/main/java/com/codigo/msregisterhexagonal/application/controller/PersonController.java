package com.codigo.msregisterhexagonal.application.controller;

import com.codigo.msregisterhexagonal.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregisterhexagonal.domain.ports.in.EmpresaServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/empresa")
@RequiredArgsConstructor
public class PersonController {

    private final EmpresaServiceIn empresaServiceIn;

    @PostMapping("/{ruc}")
    public ResponseEntity<EmpresaDTO> createEmpresa(@PathVariable("ruc") String ruc) {
        return ResponseEntity.ok(empresaServiceIn.createEmpresa(ruc));
    }

    // Manejo de excepciones
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}
