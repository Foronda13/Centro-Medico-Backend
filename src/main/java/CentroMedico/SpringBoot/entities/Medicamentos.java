package CentroMedico.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Medicamentos", schema = "dbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MedicamentoID")
    private Integer medicamentoID;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Laboratorio")
    private String laboratorio;
}
