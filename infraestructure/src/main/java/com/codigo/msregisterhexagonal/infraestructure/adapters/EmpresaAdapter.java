package com.codigo.msregisterhexagonal.infraestructure.adapters;

import com.codigo.msregisterhexagonal.domain.aggregates.constants.Constants;
import com.codigo.msregisterhexagonal.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregisterhexagonal.domain.aggregates.response.ResponseReniec;
import com.codigo.msregisterhexagonal.domain.ports.out.EmpresaServiceOut;
import com.codigo.msregisterhexagonal.infraestructure.dao.EmpresaRepository;
import com.codigo.msregisterhexagonal.infraestructure.entity.EmpresaEntity;
import com.codigo.msregisterhexagonal.infraestructure.mapper.EmpresaMapper;
import com.codigo.msregisterhexagonal.infraestructure.rest.ReniecClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmpresaAdapter implements EmpresaServiceOut {

    private final EmpresaRepository empresaRepository;
    private final ReniecClient reniecClient;
    private final EmpresaMapper empresaMapper;

    @Value("${token.api}")
    private String token;
    @Override
    public EmpresaDTO createPersonOut(String ruc) {
        EmpresaEntity emprsa = getEntity(ruc);
        EmpresaEntity dato = empresaRepository.save(emprsa);
        EmpresaDTO dto = empresaMapper.mapToDto(dato);
        log.info("dato del dto: " + dto.toString() );
        return dto;
    }

    private EmpresaEntity getEntity(String ruc){
        ResponseReniec responseReniec = execute(ruc);
        if(Objects.nonNull(responseReniec)){
            return EmpresaEntity.builder()
                    .razonSocial(responseReniec.getRazonSocial())
                    .tipoDocumento(responseReniec.getTipoDocumento())
                    .numeroDocumento(responseReniec.getNumeroDocumento())
                    .estado(responseReniec.getEstado())
                    .condicion(responseReniec.getCondicion())
                    .direccion(responseReniec.getDireccion())
                    .ubigeo(responseReniec.getUbigeo())
                    .viaTipo(responseReniec.getViaTipo())
                    .viaNombre(responseReniec.getViaNombre())
                    .zonaCodigo(responseReniec.getZonaCodigo())
                    .zonaTipo(responseReniec.getZonaTipo())
                    .numero(responseReniec.getNumero())
                    .interior(responseReniec.getInterior())
                    .lote(responseReniec.getLote())
                    .dpto(responseReniec.getDpto())
                    .manzana(responseReniec.getManzana())
                    .kilometro(responseReniec.getKilometro())
                    .distrito(responseReniec.getDistrito())
                    .provincia(responseReniec.getProvincia())
                    .departamento(responseReniec.getDepartamento())
                    .esAgenteRetencion(responseReniec.isEsAgenteRetencion())
                    .tipo(responseReniec.getTipo())
                    .actividadEconomica(responseReniec.getActividadEconomica())
                    .numeroTrabajadores(responseReniec.getNumeroTrabajadores())
                    .tipoFacturacion(responseReniec.getTipoFacturacion())
                    .tipoContabilidad(responseReniec.getTipoContabilidad())
                    .comercioExterior(responseReniec.getComercioExterior())
                    .estado_activo(Constants.ACTIVE)
                    .usua_crea(Constants.USU_ADMIN)
                    .date_crea(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return null;
    }

    private ResponseReniec execute(String ruc){
        String head = "Bearer "+ token;
        return reniecClient.getInfoReniec(ruc,head);
    }
}
