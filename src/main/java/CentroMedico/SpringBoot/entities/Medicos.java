package CentroMedico.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Medicos", schema = "dbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MedicoID")
    private Integer medicoID;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "EspecialidadID")
    private Especialidades especialidad; 

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Licencia", unique = true, nullable = false)
    private String licencia;
}