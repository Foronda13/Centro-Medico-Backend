package CentroMedico.SpringBoot.repository;

import CentroMedico.SpringBoot.entities.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {
}