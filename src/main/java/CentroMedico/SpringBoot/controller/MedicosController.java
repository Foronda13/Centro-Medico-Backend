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

import CentroMedico.SpringBoot.entities.Medicos;
import CentroMedico.SpringBoot.service.ServiceMedicos;

@RestController
@RequestMapping("/api/medicos")
public class MedicosController {

    @Autowired
    private ServiceMedicos serviceMedicos;

    // Obtener todos
    @GetMapping
    public List<Medicos> listar() {
        return serviceMedicos.getMedicos();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Medicos buscar(@PathVariable Integer id) {
        return serviceMedicos.getMedicoById(id);
    }

    // Crear nuevo médico
    @PostMapping
    public void crear(@RequestBody Medicos medico) {
        serviceMedicos.guardar(medico);
    }

    // Actualizar 
    @PutMapping("/{id}")
    public Medicos actualizar(@PathVariable Integer id, @RequestBody Medicos medico) {
        Medicos existe = serviceMedicos.getMedicoById(id);
        
        if (existe != null) {
            existe.setNombre(medico.getNombre());
            existe.setApellido(medico.getApellido());
            existe.setEspecialidad(medico.getEspecialidad());
            existe.setEmail(medico.getEmail());
            existe.setLicencia(medico.getLicencia());
            serviceMedicos.guardar(existe);
            return existe;
        }
        return null;
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceMedicos.eliminar(id);
    }
}
