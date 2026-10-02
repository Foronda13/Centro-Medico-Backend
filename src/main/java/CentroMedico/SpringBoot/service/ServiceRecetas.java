package CentroMedico.SpringBoot.service;

import CentroMedico.SpringBoot.entities.Recetas;
import java.util.List;

public interface ServiceRecetas {
    List<Recetas> getRecetas();
    Recetas getRecetaById(Integer id);
    Recetas guardar(Recetas receta);
    void eliminar(Integer id);
}