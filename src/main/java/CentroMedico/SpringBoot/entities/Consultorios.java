package CentroMedico.SpringBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Consultorios", schema = "dbo") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConsultorioID")
    private Integer consultorioID;

    @Column(name = "Numero", nullable = false)
    private String numero;

    @Column(name = "Piso")
    private Integer piso;

    @Column(name = "TipoConsultorio") 
    private String tipoConsultorio;
}