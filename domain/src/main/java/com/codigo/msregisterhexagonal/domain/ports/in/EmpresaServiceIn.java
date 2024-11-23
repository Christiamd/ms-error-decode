package com.codigo.msregisterhexagonal.domain.ports.in;

import com.codigo.msregisterhexagonal.domain.aggregates.dto.EmpresaDTO;

public interface EmpresaServiceIn {
    EmpresaDTO createEmpresa(String ruc);
}
