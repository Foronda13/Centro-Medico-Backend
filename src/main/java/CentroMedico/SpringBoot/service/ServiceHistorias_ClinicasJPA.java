package CentroMedico.SpringBoot.service;

import CentroMedico.SpringBoot.entities.Historias_Clinicas;
import CentroMedico.SpringBoot.repository.Historias_ClinicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceHistorias_ClinicasJPA implements ServiceHistorias_Clinicas {

    @Autowired
    private Historias_ClinicasRepository historias_ClinicasRepository;

    @Override
    public List<Historias_Clinicas> getHistorias() {
        return historias_ClinicasRepository.findAll();
    }

    @Override
    public Historias_Clinicas getHistoriaById(Integer id) {
        return historias_ClinicasRepository.findById(id).orElse(null);
    }

    @Override
    public Historias_Clinicas guardar(Historias_Clinicas historia) {
        return historias_ClinicasRepository.save(historia);
    }

    @Override
    public void eliminar(Integer id) {
        historias_ClinicasRepository.deleteById(id);
    }
}