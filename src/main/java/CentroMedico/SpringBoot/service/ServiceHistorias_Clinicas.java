package CentroMedico.SpringBoot.service;

import CentroMedico.SpringBoot.entities.Historias_Clinicas;
import java.util.List;

public interface ServiceHistorias_Clinicas {
    List<Historias_Clinicas> getHistorias();
    Historias_Clinicas getHistoriaById(Integer id);
    Historias_Clinicas guardar(Historias_Clinicas historia);
    void eliminar(Integer id);
}