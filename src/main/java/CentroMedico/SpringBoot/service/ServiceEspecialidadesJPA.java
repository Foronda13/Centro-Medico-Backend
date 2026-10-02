package CentroMedico.SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CentroMedico.SpringBoot.entities.Especialidades;
import CentroMedico.SpringBoot.repository.EspecialidadesRepository;
import java.util.List;

@Service
public class ServiceEspecialidadesJPA implements ServiceEspecialidades {

    @Autowired
    private EspecialidadesRepository especialidadesRepository;

    @Override
    public List<Especialidades> getEspecialidades() {
        return especialidadesRepository.findAll();
    }

    @Override
    public Especialidades obtenerPorId(Integer id) {
        return especialidadesRepository.findById(id).orElse(null);
    }

    @Override
    public Especialidades guardarEspecialidad(Especialidades especialidad) {
        return especialidadesRepository.save(especialidad);
    }
    
    @Override
    public void eliminarEspecialidad(Integer id) {
        especialidadesRepository.deleteById(id);
    }
}