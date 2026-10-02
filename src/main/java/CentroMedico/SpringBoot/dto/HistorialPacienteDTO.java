package CentroMedico.SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialPacienteDTO {
    private Integer citaID;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;
}