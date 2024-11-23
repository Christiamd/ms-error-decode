package com.codigo.msregisterhexagonal.infraestructure.mapper;

import com.codigo.msregisterhexagonal.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregisterhexagonal.infraestructure.entity.EmpresaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmpresaMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public EmpresaDTO mapToDto(EmpresaEntity empresaEntity){
        return MODEL_MAPPER.map(empresaEntity, EmpresaDTO.class);
    }
    public EmpresaEntity mapToEntity(EmpresaDTO empresaDTO){
        return MODEL_MAPPER.map(empresaDTO, EmpresaEntity.class);
    }

}
