package pe.inpe.ms_personal.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.inpe.ms_personal.dto.PersonalRequestDTO;
import pe.inpe.ms_personal.dto.PersonalResponseDTO;
import pe.inpe.ms_personal.dto.PersonalSedeResponseDTO;
import pe.inpe.ms_personal.entity.PersonalPenitenciario;
import pe.inpe.ms_personal.exception.BadRequestException;
import pe.inpe.ms_personal.exception.ResourceNotFoundException;
import pe.inpe.ms_personal.mapper.PersonalMapper;
import pe.inpe.ms_personal.repository.PersonalRepository;
import pe.inpe.ms_personal.service.PersonalService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;
    private final PersonalMapper personalMapper;

    @Override
    @Transactional
    public PersonalResponseDTO addPersonal(PersonalRequestDTO request) {
        log.info("Creando nuevo personal : {}", request.getIdPersona());

        PersonalPenitenciario personal= personalMapper.toEntity(request);
        personal.setEstado(true);
        PersonalPenitenciario saved = personalRepository.save(personal);
        log.info("Personal creado con ID: {}", saved.getIdPersonal());

        return personalMapper.toResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalResponseDTO getPersonalXID(Long id) {
        log.info("Buscando personal con ID: {}", id);
        PersonalPenitenciario personal=personalRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Personal no encontrado con ID :"+id
                ));
        return personalMapper.toResponseDTO(personal);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalResponseDTO getPersonalXIDPersona(Long idPersona) {
        log.info("Buscando persona con ID: {}", idPersona);
        PersonalPenitenciario personal = personalRepository.findByIdPersona(idPersona)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Personal no encontrado para la persona con ID: " + idPersona));

        return personalMapper.toResponseDTO(personal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalResponseDTO> getPersonalXIDSede(Long idInstitutoSede) {
        log.info("Buscando personal con ID sede: {}", idInstitutoSede);
        return personalRepository.findByIdInstitutoSede(idInstitutoSede)
                .stream()
                .map(personalMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalSedeResponseDTO getSedeByPersonal(Long idPersonal) {
        log.info("Buscando sede por ID personal :{}", idPersonal);

        PersonalPenitenciario personal = personalRepository.findById(idPersonal)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Personal no encontrado con ID: " + idPersonal));

        if (personal.getIdInstitutoSede() == null) {
            throw new BadRequestException(
                    "El personal con ID: " + idPersonal + " no tiene una sede asignada.");
        }

        return personalMapper.toSedeResponseDTO(personal);
    }
}
