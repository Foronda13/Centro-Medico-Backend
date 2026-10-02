package CentroMedico.SpringBoot.service;

import java.util.List;

import CentroMedico.SpringBoot.entities.Medicos;

public interface ServiceMedicos {
    List<Medicos> getMedicos();
    Medicos getMedicoById(Integer id);
    void guardar(Medicos medico);
    void eliminar(Integer id);
}
