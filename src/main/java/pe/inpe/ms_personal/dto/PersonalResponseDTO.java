package pe.inpe.ms_personal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalResponseDTO {

    private Long idPersonal;
    private Long idPersona;
    private String nombreCompleto;
    private Long idInstitutoSede;
    private String nombreSede;
    private Long cargoId;
    private String nombreCargo;
    private Boolean estado;
}
