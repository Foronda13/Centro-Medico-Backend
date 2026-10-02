package CentroMedico.SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumenCitaDTO {
    private Integer citaID;
    private String paciente;
    private String medico;
    private String especialidad;
    private String diagnostico;
    private String medicamento;
    private String dosis;
}