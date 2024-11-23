package com.codigo.msregisterhexagonal.infraestructure.dao;

import com.codigo.msregisterhexagonal.infraestructure.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
