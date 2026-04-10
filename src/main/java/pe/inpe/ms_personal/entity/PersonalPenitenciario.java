package pe.inpe.ms_personal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.inpe.ms_personal.Util.AudithModel;

@Entity
@Table(name = "personal_penitenciario")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersonalPenitenciario extends AudithModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal")
    private Long idPersonal;

    @Column(name = "id_persona", nullable = false, unique = true)
    private Long idPersona;

    @Column(name = "id_instituto_sede")
    private Long idInstitutoSede;

    @Column(name = "cargo_id")
    private Long cargoId;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;
}