package CentroMedico.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Historias_Clinicas", schema = "dbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Historias_Clinicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HistoriaID")
    private Integer historiaID;

    @OneToOne
    @JoinColumn(name = "CitaID", unique = true) 
    private Citas cita;

    @Column(name = "Diagnostico", nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String diagnostico;

    @Column(name = "Tratamiento", columnDefinition = "NVARCHAR(MAX)")
    private String tratamiento;

    @Column(name = "FechaRegistro")
    private LocalDateTime fechaRegistro = LocalDateTime.now(); 
}