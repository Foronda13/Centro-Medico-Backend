package CentroMedico.SpringBoot.service;

import java.util.List;
import CentroMedico.SpringBoot.entities.Consultorios;

public interface ServiceConsultorios {
    public List<Consultorios> getConsultorios();
    public Consultorios obtenerPorId(Integer id);
    public Consultorios guardarConsultorio(Consultorios consultorio);
    public void eliminarConsultorio(Integer id);
}