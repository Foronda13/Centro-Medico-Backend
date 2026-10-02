package CentroMedico.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CentroMedico.SpringBoot.entities.Medicamentos;
import CentroMedico.SpringBoot.repository.MedicamentosRepository;

@Service
public class ServiceMedicamentosJPA implements ServiceMedicamentos {
    
    @Autowired
    private MedicamentosRepository medicamentosRepository;

    @Override
    public List<Medicamentos> getMedicamentos() {
        return medicamentosRepository.findAll();
    }

    @Override
    public Medicamentos getMedicamentoById(Integer id) {
        return medicamentosRepository.findById(id).orElse(null);
    }

    @Override
    public Medicamentos guardar(Medicamentos medicamento) {
        return medicamentosRepository.save(medicamento);
    }

    @Override
    public void eliminar(Integer id) {
        medicamentosRepository.deleteById(id);
    }
}
