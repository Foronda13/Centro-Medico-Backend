package CentroMedico.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Citas", schema = "dbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CitaID")
    private Integer citaID;

    @ManyToOne
    @JoinColumn(name = "PacienteID")
    private Pacientes paciente;

    @ManyToOne
    @JoinColumn(name = "MedicoID")
    private Medicos medico;

    @ManyToOne
    @JoinColumn(name = "ConsultorioID")
    private Consultorios consultorio;

    @Column(name = "FechaHora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "Motivo")
    private String motivo;

    @Column(name = "Estado")
    private String estado = "Programada"; 
}