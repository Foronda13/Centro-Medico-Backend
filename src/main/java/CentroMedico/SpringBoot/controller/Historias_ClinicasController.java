package CentroMedico.SpringBoot.controller;

import CentroMedico.SpringBoot.entities.Historias_Clinicas;
import CentroMedico.SpringBoot.service.ServiceHistorias_Clinicas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historias-clinicas")
public class Historias_ClinicasController {

    @Autowired
    private ServiceHistorias_Clinicas serviceHistorias_Clinicas;

    @GetMapping
    public List<Historias_Clinicas> listar() {
        return serviceHistorias_Clinicas.getHistorias();
    }

    @GetMapping("/{id}")
    public Historias_Clinicas buscar(@PathVariable Integer id) {
        return serviceHistorias_Clinicas.getHistoriaById(id);
    }

    @PostMapping
    public Historias_Clinicas crear(@RequestBody Historias_Clinicas historia) {
        return serviceHistorias_Clinicas.guardar(historia);
    }

    @PutMapping("/{id}")
    public Historias_Clinicas actualizar(@PathVariable Integer id, @RequestBody Historias_Clinicas historia) {
        Historias_Clinicas existe = serviceHistorias_Clinicas.getHistoriaById(id);
        if (existe != null) {
            existe.setCita(historia.getCita());
            existe.setDiagnostico(historia.getDiagnostico());
            existe.setTratamiento(historia.getTratamiento());
            return serviceHistorias_Clinicas.guardar(existe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceHistorias_Clinicas.eliminar(id);
    }
}