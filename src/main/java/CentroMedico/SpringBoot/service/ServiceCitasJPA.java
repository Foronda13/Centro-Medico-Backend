package CentroMedico.SpringBoot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CentroMedico.SpringBoot.dto.CitasPorEspecialidadDTO;
import CentroMedico.SpringBoot.dto.HistorialPacienteDTO;
import CentroMedico.SpringBoot.dto.ResumenCitaDTO;
import CentroMedico.SpringBoot.entities.Citas;
import CentroMedico.SpringBoot.repository.CitasRepository;

@Service
public class ServiceCitasJPA implements ServiceCitas {

    @Autowired
    private CitasRepository citasRepository;

    @Override
    public List<Citas> getCitas() {
        return citasRepository.findAll();
    }

    @Override
    public Citas getCitaById(Integer id) {
        return citasRepository.findById(id).orElse(null);
    }

    @Override
    public Citas guardar(Citas cita) {
        return citasRepository.save(cita);
    }

    @Override
    public void eliminar(Integer id) {
        citasRepository.deleteById(id);
    }

    @Override
    public List<ResumenCitaDTO> getResumenCitas() {
    return citasRepository.obtenerResumenCitasNativo().stream().map(p -> new ResumenCitaDTO(
        p.getCitaID(),
        p.getPaciente(),
        p.getMedico(),
        p.getEspecialidad(),
        p.getDiagnostico(),
        p.getMedicamento(),
        p.getDosis()
        )).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<CitasPorEspecialidadDTO> getEstadisticasEspecialidad() {
    return citasRepository.obtenerCitasPorEspecialidadNativo().stream().map(p -> new CitasPorEspecialidadDTO(
        p.getEspecialidad(),
        p.getTotalCitas()
        )).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<HistorialPacienteDTO> getHistorialPorDniYEstado(String dni, String estado) {
        return citasRepository.buscarPorDniYEstadoNativo(dni, estado)
                .stream()
                .map(p -> new HistorialPacienteDTO(
                        p.getCitaID(),
                        p.getFechaHora(),
                        p.getMotivo(),
                        p.getEstado()
                ))
                .collect(Collectors.toList());
    }
}