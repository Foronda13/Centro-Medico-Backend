package CentroMedico.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Pacientes", schema = "dbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PacienteID")
    private Integer pacienteID;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "DNI", unique = true, nullable = false)
    private String dni;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "Telefono")
    private String telefono;
}
