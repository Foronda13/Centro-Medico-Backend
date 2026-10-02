package CentroMedico.SpringBoot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import CentroMedico.SpringBoot.entities.Consultorios;
import CentroMedico.SpringBoot.service.ServiceConsultorios;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultoriosController {

    @Autowired
    private ServiceConsultorios serviceConsultorios;

    @GetMapping
    public List<Consultorios> listar() {
        return serviceConsultorios.getConsultorios();
    }

    @GetMapping("/{id}")
    public Consultorios buscar(@PathVariable Integer id) {
        return serviceConsultorios.obtenerPorId(id);
    }

    @PostMapping
    public Consultorios crear(@RequestBody Consultorios consultorio) {
        return serviceConsultorios.guardarConsultorio(consultorio);
    }

    @PutMapping("/{id}")
    public Consultorios actualizar(@PathVariable Integer id, @RequestBody Consultorios consultorio) {
        Consultorios existe = serviceConsultorios.obtenerPorId(id);
        if (existe != null) {
            existe.setNumero(consultorio.getNumero());
            existe.setPiso(consultorio.getPiso());
            existe.setTipoConsultorio(consultorio.getTipoConsultorio());
            return serviceConsultorios.guardarConsultorio(existe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Integer id) {
        serviceConsultorios.eliminarConsultorio(id);
        return "Consultorio " + id + " eliminado";
    }
}