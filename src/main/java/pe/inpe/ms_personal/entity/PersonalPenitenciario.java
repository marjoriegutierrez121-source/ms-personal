package pe.inpe.ms_personal.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.inpe.ms_personal.Util.auditoria.AuditModel;

@Entity
@Table(name = "personal_penitenciario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalPenitenciario extends AuditModel {


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