package CentroMedico.SpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Especialidades") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especialidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "EspecialidadID") 
    private Integer especialidadID;  

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
}