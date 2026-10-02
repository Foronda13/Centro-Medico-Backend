package CentroMedico.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CentroMedico.SpringBoot.entities.Especialidades;

@Repository
public interface EspecialidadesRepository extends JpaRepository<Especialidades, Integer> {
}