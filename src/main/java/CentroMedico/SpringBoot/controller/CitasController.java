package CentroMedico.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CentroMedico.SpringBoot.dto.CitasPorEspecialidadDTO;
import CentroMedico.SpringBoot.dto.HistorialPacienteDTO;
import CentroMedico.SpringBoot.dto.ResumenCitaDTO;
import CentroMedico.SpringBoot.entities.Citas;
import CentroMedico.SpringBoot.service.ServiceCitas;

@RestController
@CrossOrigin(origins = "http://localhost:5173") 
@RequestMapping("/api/citas")
public class CitasController {

    @Autowired
    private ServiceCitas serviceCitas;

    @GetMapping
    public List<Citas> listar() {
        return serviceCitas.getCitas();
    }

    @GetMapping("/{id}")
    public Citas buscar(@PathVariable Integer id) {
        return serviceCitas.getCitaById(id);
    }

    @PostMapping
    public Citas crear(@RequestBody Citas cita) {
        return serviceCitas.guardar(cita);
    }

    @PutMapping("/{id}")
    public Citas actualizar(@PathVariable Integer id, @RequestBody Citas cita) {
        Citas existe = serviceCitas.getCitaById(id);
        if (existe != null) {
            existe.setPaciente(cita.getPaciente());
            existe.setMedico(cita.getMedico());
            existe.setConsultorio(cita.getConsultorio());
            existe.setFechaHora(cita.getFechaHora());
            existe.setMotivo(cita.getMotivo());
            existe.setEstado(cita.getEstado());
            return serviceCitas.guardar(existe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceCitas.eliminar(id);
    }

    @GetMapping("/resumen")
    public List<ResumenCitaDTO> listarResumen() {
    return serviceCitas.getResumenCitas();
    }

    @GetMapping("/estadisticas/especialidad")
    public List<CitasPorEspecialidadDTO> obtenerEstadisticas() {
    return serviceCitas.getEstadisticasEspecialidad();
    }

    //Ruta = http://localhost:8080/api/citas/buscar-historial?dni=87654321B&estado=Completada
    //Siempre cambiar el DNI de la persona por el que se quiera buscar, y el estado por el que se quiera filtrar (Pendiente, Completada, Cancelada)
    @GetMapping("/buscar-historial")
    public ResponseEntity<List<HistorialPacienteDTO>> filtrarHistorial(
            @RequestParam String dni, 
            @RequestParam String estado) {
        
        List<HistorialPacienteDTO> historial = serviceCitas.getHistorialPorDniYEstado(dni, estado);
        return ResponseEntity.ok(historial);
    }
}