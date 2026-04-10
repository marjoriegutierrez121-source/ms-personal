package pe.inpe.ms_personal.service;

import pe.inpe.ms_personal.dto.PersonalRequestDTO;
import pe.inpe.ms_personal.dto.PersonalResponseDTO;
import pe.inpe.ms_personal.dto.PersonalSedeResponseDTO;

import java.util.List;

public interface PersonalService {

    PersonalResponseDTO addPersonal(PersonalRequestDTO request);

    PersonalResponseDTO getPersonalXID(Long id);

    PersonalResponseDTO getPersonalXIDPersona(Long idPersona);

    List<PersonalResponseDTO> getPersonalXIDSede(Long idInstitutoSede);

    PersonalSedeResponseDTO getSedeByPersonal(Long idPersonal);

}
