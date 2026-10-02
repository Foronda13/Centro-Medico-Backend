package CentroMedico.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CentroMedico.SpringBoot.entities.Consultorios;

@Repository
public interface ConsultoriosRepository extends JpaRepository<Consultorios, Integer> {
}