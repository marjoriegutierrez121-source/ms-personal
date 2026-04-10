package pe.inpe.ms_personal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pe.inpe.ms_personal.dto.PersonalRequestDTO;
import pe.inpe.ms_personal.dto.PersonalResponseDTO;
import pe.inpe.ms_personal.dto.PersonalSedeResponseDTO;
import pe.inpe.ms_personal.entity.PersonalPenitenciario;

@Mapper(componentModel = "spring")
public interface PersonalMapper {

    // RequestDTO → Entity
    @Mapping(target = "idPersonal", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "registrationUser", ignore = true)
    @Mapping(target = "lastModificationDate", ignore = true)
    @Mapping(target = "lastModificationUser", ignore = true)
    PersonalPenitenciario toEntity(PersonalRequestDTO requestDTO);

    // Entity → PersonalResponseDTO
    PersonalResponseDTO toResponseDTO(PersonalPenitenciario entity);

    // Entity → PersonalSedeResponseDTO (usado en GET /personal/{id}/sede)
    PersonalSedeResponseDTO toSedeResponseDTO(PersonalPenitenciario entity);

    // Actualizar entity existente
    @Mapping(target = "idPersonal", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "registrationUser", ignore = true)
    @Mapping(target = "lastModificationDate", ignore = true)
    @Mapping(target = "lastModificationUser", ignore = true)
    void updateEntity(PersonalRequestDTO requestDTO, @MappingTarget PersonalPenitenciario entity);
}