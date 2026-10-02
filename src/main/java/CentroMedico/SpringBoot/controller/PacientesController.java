package CentroMedico.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CentroMedico.SpringBoot.entities.Pacientes;
import CentroMedico.SpringBoot.service.ServicePacientes;

@RestController
@RequestMapping("/api/pacientes")
public class PacientesController {

    @Autowired
    private ServicePacientes servicePacientes;

    @GetMapping
    public List<Pacientes> listar() {
        return servicePacientes.getPacientes();
    }

    @GetMapping("/{id}")
    public Pacientes buscar(@PathVariable Integer id) {
        return servicePacientes.getPacienteById(id);
    }

    @PostMapping
    public Pacientes crear(@RequestBody Pacientes paciente) {
        return servicePacientes.guardar(paciente);
    }

    @PutMapping("/{id}")
    public Pacientes actualizar(@PathVariable Integer id, @RequestBody Pacientes paciente) {
        Pacientes existe = servicePacientes.getPacienteById(id);
        if (existe != null) {
            existe.setNombre(paciente.getNombre());
            existe.setApellido(paciente.getApellido());
            existe.setDni(paciente.getDni());
            existe.setFechaNacimiento(paciente.getFechaNacimiento());
            existe.setTelefono(paciente.getTelefono());
            return servicePacientes.guardar(existe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicePacientes.eliminar(id);
    }
}
