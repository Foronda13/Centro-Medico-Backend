package CentroMedico.SpringBoot.service;

import java.util.List;

import CentroMedico.SpringBoot.entities.Medicamentos;

public interface ServiceMedicamentos {
    List<Medicamentos> getMedicamentos();
    Medicamentos getMedicamentoById(Integer id);
    Medicamentos guardar(Medicamentos medicamento);
    void eliminar(Integer id);
}
