package CentroMedico.SpringBoot.repository;

import CentroMedico.SpringBoot.entities.Recetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetasRepository extends JpaRepository<Recetas, Integer> {
}