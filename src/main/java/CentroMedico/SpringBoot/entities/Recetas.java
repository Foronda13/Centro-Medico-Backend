package CentroMedico.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Recetas", schema = "dbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecetaID")
    private Integer recetaID;

    @ManyToOne
    @JoinColumn(name = "HistoriaID")
    private Historias_Clinicas historiaClinica;

    @ManyToOne
    @JoinColumn(name = "MedicamentoID")
    private Medicamentos medicamento;

    @Column(name = "Dosis")
    private String dosis;

    @Column(name = "Duracion")
    private String duracion;
}