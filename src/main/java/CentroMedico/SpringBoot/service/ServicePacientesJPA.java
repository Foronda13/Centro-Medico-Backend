package CentroMedico.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CentroMedico.SpringBoot.entities.Pacientes;
import CentroMedico.SpringBoot.repository.PacientesRepository;

@Service
public class ServicePacientesJPA implements ServicePacientes {
    @Autowired
    private PacientesRepository pacientesRepository;

    @Override
    public List<Pacientes> getPacientes() {
        return pacientesRepository.findAll();
    }

    @Override
    public Pacientes getPacienteById(Integer id) {
        return pacientesRepository.findById(id).orElse(null);
    }

    @Override
    public Pacientes guardar(Pacientes paciente) {
        return pacientesRepository.save(paciente);
    }

    @Override
    public void eliminar(Integer id) {
        pacientesRepository.deleteById(id);
    }
}