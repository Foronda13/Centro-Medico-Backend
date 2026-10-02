package CentroMedico.SpringBoot.repository;

import CentroMedico.SpringBoot.entities.Historias_Clinicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Historias_ClinicasRepository extends JpaRepository<Historias_Clinicas, Integer> {
}