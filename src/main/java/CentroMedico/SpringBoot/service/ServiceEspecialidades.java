package CentroMedico.SpringBoot.service;

import java.util.List;
import CentroMedico.SpringBoot.entities.Especialidades;

public interface ServiceEspecialidades {
    
    public List<Especialidades> getEspecialidades();
    
    public Especialidades obtenerPorId(Integer id);
    
    public Especialidades guardarEspecialidad(Especialidades especialidad);
    
    public void eliminarEspecialidad(Integer id);
}