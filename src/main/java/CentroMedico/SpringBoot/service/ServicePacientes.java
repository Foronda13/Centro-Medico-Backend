package CentroMedico.SpringBoot.service;

import java.util.List;

import CentroMedico.SpringBoot.entities.Pacientes;

public interface ServicePacientes {
    List<Pacientes> getPacientes();
    Pacientes getPacienteById(Integer id);
    Pacientes guardar(Pacientes paciente);
    void eliminar(Integer id);
}
