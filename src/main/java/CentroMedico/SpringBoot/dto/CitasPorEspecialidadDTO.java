package CentroMedico.SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitasPorEspecialidadDTO {
    private String especialidad;
    private Long totalCitas; 
}