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

import CentroMedico.SpringBoot.entities.Especialidades;
import CentroMedico.SpringBoot.service.ServiceEspecialidades;

@RestController
@RequestMapping("/api/especialidades") 
public class EspecialidadesController {

    @Autowired
    private ServiceEspecialidades serviceEspecialidades;

    // 1. Leer = GET http://localhost:8080/api/especialidades
    @GetMapping
    public List<Especialidades> MostrarEspecialidades() {
        return serviceEspecialidades.getEspecialidades();
    }

    // 2. Leer por ID = GET http://localhost:8080/api/especialidades/{id}
    @GetMapping("/{id}")
    public Especialidades obtenerPorId(@PathVariable Integer id) {
        return serviceEspecialidades.obtenerPorId(id);
    }

    // 3. Crear = POST http://localhost:8080/api/especialidades
    @PostMapping
    public Especialidades crearEspecialidad(@RequestBody Especialidades especialidad) {
        return serviceEspecialidades.guardarEspecialidad(especialidad);
    }

    // 4. Actualizar = PUT http://localhost:8080/api/especialidades/{id}
    @PutMapping("/{id}")
    public Especialidades actualizarEspecialidad(@PathVariable Integer id, @RequestBody Especialidades especialidad) {
        Especialidades existente = serviceEspecialidades.obtenerPorId(id);
        if (existente != null) {
            existente.setNombre(especialidad.getNombre());
            return serviceEspecialidades.guardarEspecialidad(existente); 
        }
        return null;
    }

    // 5. Eliminar = DELETE http://localhost:8080/api/especialidades/{id}
    @DeleteMapping("/{id}")
    public String eliminarEspecialidad(@PathVariable Integer id) {
        serviceEspecialidades.eliminarEspecialidad(id);
        return "Especialidad eliminada correctamente con el ID: " + id;
    }
}