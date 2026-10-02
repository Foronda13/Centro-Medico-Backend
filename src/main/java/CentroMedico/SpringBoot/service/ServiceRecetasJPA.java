package CentroMedico.SpringBoot.service;

import CentroMedico.SpringBoot.entities.Recetas;
import CentroMedico.SpringBoot.repository.RecetasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceRecetasJPA implements ServiceRecetas {

    @Autowired
    private RecetasRepository recetasRepository;

    @Override
    public List<Recetas> getRecetas() {
        return recetasRepository.findAll();
    }

    @Override
    public Recetas getRecetaById(Integer id) {
        return recetasRepository.findById(id).orElse(null);
    }

    @Override
    public Recetas guardar(Recetas receta) {
        return recetasRepository.save(receta);
    }

    @Override
    public void eliminar(Integer id) {
        recetasRepository.deleteById(id);
    }
}