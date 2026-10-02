package CentroMedico.SpringBoot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CentroMedico.SpringBoot.entities.Consultorios;
import CentroMedico.SpringBoot.repository.ConsultoriosRepository;

@Service
public class ServiceConsultoriosJPA implements ServiceConsultorios {

    @Autowired
    private ConsultoriosRepository consultoriosRepository;

    @Override
    public List<Consultorios> getConsultorios() {
        return consultoriosRepository.findAll();
    }

    @Override
    public Consultorios obtenerPorId(Integer id) {
        return consultoriosRepository.findById(id).orElse(null);
    }

    @Override
    public Consultorios guardarConsultorio(Consultorios consultorio) {
        return consultoriosRepository.save(consultorio);
    }

    @Override
    public void eliminarConsultorio(Integer id) {
        consultoriosRepository.deleteById(id);
    }
}