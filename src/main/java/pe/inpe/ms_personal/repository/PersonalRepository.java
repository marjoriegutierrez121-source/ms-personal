package pe.inpe.ms_personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.inpe.ms_personal.entity.PersonalPenitenciario;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalRepository extends JpaRepository<PersonalPenitenciario, Long> {
    // GET /personal?personaId=1
    Optional<PersonalPenitenciario> findByIdPersona(Long idPersona);

    // GET /personal?sedeId=2
    List<PersonalPenitenciario> findByIdInstitutoSede(Long idInstitutoSede);

}
