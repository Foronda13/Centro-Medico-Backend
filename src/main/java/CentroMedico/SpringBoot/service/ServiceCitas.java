package CentroMedico.SpringBoot.service;

import java.util.List;

import CentroMedico.SpringBoot.dto.CitasPorEspecialidadDTO;
import CentroMedico.SpringBoot.dto.HistorialPacienteDTO;
import CentroMedico.SpringBoot.dto.ResumenCitaDTO;
import CentroMedico.SpringBoot.entities.Citas;

public interface ServiceCitas {
    List<Citas> getCitas();
    Citas getCitaById(Integer id);
    Citas guardar(Citas cita);
    void eliminar(Integer id);
    List<ResumenCitaDTO> getResumenCitas(); 
    List<CitasPorEspecialidadDTO> getEstadisticasEspecialidad();
    List<HistorialPacienteDTO> getHistorialPorDniYEstado(String dni, String estado);
}

