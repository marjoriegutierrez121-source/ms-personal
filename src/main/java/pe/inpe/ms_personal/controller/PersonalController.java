package pe.inpe.ms_personal.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.inpe.ms_personal.dto.GenericResponseDTO;
import pe.inpe.ms_personal.dto.PersonalRequestDTO;
import pe.inpe.ms_personal.dto.PersonalResponseDTO;
import pe.inpe.ms_personal.dto.PersonalSedeResponseDTO;
import pe.inpe.ms_personal.exception.BadRequestException;
import pe.inpe.ms_personal.service.PersonalService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/personal")
public class PersonalController {
    private final PersonalService personalService;
    @PostMapping
    public ResponseEntity<GenericResponseDTO<PersonalResponseDTO>> addPersonal(
            @RequestBody PersonalRequestDTO request) {
        log.info("Recibida petición agregar personal");
        PersonalResponseDTO data = personalService.addPersonal(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                GenericResponseDTO.<PersonalResponseDTO>builder()
                        .response(data)
                        .error(null)
                        .build()
        );
    }
    // GET /personal/{id}
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDTO<PersonalResponseDTO>> getPersonalXID(
            @PathVariable Long id) {
        log.info("Recibida petición obtener personal/{}", id);
        PersonalResponseDTO data = personalService.getPersonalXID(id);
        return ResponseEntity.ok(
                GenericResponseDTO.<PersonalResponseDTO>builder()
                        .response(data)
                        .error(null)
                        .build()
        );
    }
    // GET /personal?personaId=1
    // GET /personal?sedeId=2
    @GetMapping
    public ResponseEntity<GenericResponseDTO<?>> buscar(
            @RequestParam(required = false) Long personaId,
            @RequestParam(required = false) Long sedeId) {
        if (personaId != null) {
            log.info("Recibida petición obtener personal?personaId={}", personaId);
            PersonalResponseDTO data = personalService.getPersonalXIDPersona(personaId);
            return ResponseEntity.ok(
                    GenericResponseDTO.<PersonalResponseDTO>builder()
                            .response(data)
                            .error(null)
                            .build()
            );
        }
        if (sedeId != null) {
            log.info("Recibida petición obtener personal?sedeId={}", sedeId);
            List<PersonalResponseDTO> data = personalService.getPersonalXIDSede(sedeId);
            return ResponseEntity.ok(
                    GenericResponseDTO.<List<PersonalResponseDTO>>builder()
                            .response(data)
                            .error(null)
                            .build()
            );
        }
        throw new BadRequestException(
                "Debe proporcionar al menos un parámetro de búsqueda: 'personaId' o 'sedeId'");
    }

    // GET /personal/{id}/sede
    @GetMapping("/{id}/sede")
    public ResponseEntity<GenericResponseDTO<PersonalSedeResponseDTO>> getSedeByPersonal(
            @PathVariable Long id) {
        log.info("Recibida petición obtener personal/{}/sede", id);

        PersonalSedeResponseDTO data = personalService.getSedeByPersonal(id);

        return ResponseEntity.ok(
                GenericResponseDTO.<PersonalSedeResponseDTO>builder()
                        .response(data)
                        .error(null)
                        .build()
        );
    }
}
