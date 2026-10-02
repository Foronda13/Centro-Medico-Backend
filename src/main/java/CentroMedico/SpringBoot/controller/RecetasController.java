package CentroMedico.SpringBoot.controller;

import CentroMedico.SpringBoot.entities.Recetas;
import CentroMedico.SpringBoot.service.ServiceRecetas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecetasController {

    @Autowired
    private ServiceRecetas serviceRecetas;

    @GetMapping
    public List<Recetas> listar() {
        return serviceRecetas.getRecetas();
    }

    @GetMapping("/{id}")
    public Recetas buscar(@PathVariable Integer id) {
        return serviceRecetas.getRecetaById(id);
    }

    @PostMapping
    public Recetas crear(@RequestBody Recetas receta) {
        return serviceRecetas.guardar(receta);
    }

    @PutMapping("/{id}")
    public Recetas actualizar(@PathVariable Integer id, @RequestBody Recetas receta) {
        Recetas existe = serviceRecetas.getRecetaById(id);
        if (existe != null) {
            existe.setHistoriaClinica(receta.getHistoriaClinica());
            existe.setMedicamento(receta.getMedicamento());
            existe.setDosis(receta.getDosis());
            existe.setDuracion(receta.getDuracion());
            return serviceRecetas.guardar(existe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceRecetas.eliminar(id);
    }
}