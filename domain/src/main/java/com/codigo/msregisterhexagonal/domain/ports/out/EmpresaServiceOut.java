package com.codigo.msregisterhexagonal.domain.ports.out;

import com.codigo.msregisterhexagonal.domain.aggregates.dto.EmpresaDTO;

public interface EmpresaServiceOut {
    EmpresaDTO createPersonOut(String ruc);
}
