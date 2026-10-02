package CentroMedico.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CentroMedico.SpringBoot.entities.Medicos;
import CentroMedico.SpringBoot.repository.MedicosRepository;

@Service
public class ServiceMedicosJPA implements ServiceMedicos {
    @Autowired
    private MedicosRepository medicosRepository;

    @Override
    public List<Medicos> getMedicos() {
        return medicosRepository.findAll();
    }

    @Override
    public Medicos getMedicoById(Integer id) {
        return medicosRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Medicos medico) {
        medicosRepository.save(medico);
    }

    @Override
    public void eliminar(Integer id) {
        medicosRepository.deleteById(id);
    }
}
