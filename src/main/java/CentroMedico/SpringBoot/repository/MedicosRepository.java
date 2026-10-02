package CentroMedico.SpringBoot.repository;

import CentroMedico.SpringBoot.entities.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicosRepository extends JpaRepository<Medicos, Integer> {
}