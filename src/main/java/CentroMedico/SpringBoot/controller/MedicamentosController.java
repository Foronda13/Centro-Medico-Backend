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

import CentroMedico.SpringBoot.entities.Medicamentos;
import CentroMedico.SpringBoot.service.ServiceMedicamentos;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentosController {

    @Autowired
    private ServiceMedicamentos serviceMedicamentos;

    @GetMapping
    public List<Medicamentos> listar() {
        return serviceMedicamentos.getMedicamentos();
    }

    @GetMapping("/{id}")
    public Medicamentos buscar(@PathVariable Integer id) {
        return serviceMedicamentos.getMedicamentoById(id);
    }

    @PostMapping
    public Medicamentos crear(@RequestBody Medicamentos medicamento) {
        return serviceMedicamentos.guardar(medicamento);
    }

    @PutMapping("/{id}")
    public Medicamentos actualizar(@PathVariable Integer id, @RequestBody Medicamentos medicamento) {
        Medicamentos existe = serviceMedicamentos.getMedicamentoById(id);
        if (existe != null) {
            existe.setNombre(medicamento.getNombre());
            existe.setDescripcion(medicamento.getDescripcion());
            existe.setLaboratorio(medicamento.getLaboratorio());
            return serviceMedicamentos.guardar(existe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceMedicamentos.eliminar(id);
    }
}
