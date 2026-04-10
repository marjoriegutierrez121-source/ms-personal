package pe.inpe.ms_personal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalRequestDTO {

    private Long idPersona;
    private Long idInstitutoSede;
    private Long cargoId;
    private Boolean estado;
}
