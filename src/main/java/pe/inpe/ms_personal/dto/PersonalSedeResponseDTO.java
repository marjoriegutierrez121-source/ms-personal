package pe.inpe.ms_personal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalSedeResponseDTO {

    private Long idPersonal;
    private Long idPersona;
    private String nombreCompleto;
    private Long idInstitutoSede;
    private String nombreSede;
    private String codigoSede;
    private String direccionSede;
    private Long cargoId;
    private String nombreCargo;
}