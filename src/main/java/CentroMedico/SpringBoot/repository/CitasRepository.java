package CentroMedico.SpringBoot.repository;

import CentroMedico.SpringBoot.entities.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Integer> {

    @Query(value = "SELECT " +
            "C.CitaID as citaID, " +
            "P.Nombre + ' ' + P.Apellido AS paciente, " +
            "M.Apellido AS medico, " +
            "E.Nombre AS especialidad, " +
            "H.Diagnostico as diagnostico, " +
            "Med.Nombre AS medicamento, " +
            "R.Dosis as dosis " +
            "FROM Citas C " +
            "JOIN Pacientes P ON C.PacienteID = P.PacienteID " +
            "JOIN Medicos M ON C.MedicoID = M.MedicoID " +
            "JOIN Especialidades E ON M.EspecialidadID = E.EspecialidadID " +
            "LEFT JOIN Historias_Clinicas H ON C.CitaID = H.CitaID " +
            "LEFT JOIN Recetas R ON H.HistoriaID = R.HistoriaID " +
            "LEFT JOIN Medicamentos Med ON R.MedicamentoID = Med.MedicamentoID", 
            nativeQuery = true)
    List<IResumenCitaProjection> obtenerResumenCitasNativo();

    interface IResumenCitaProjection {
        Integer getCitaID();
        String getPaciente();
        String getMedico();
        String getEspecialidad();
        String getDiagnostico();
        String getMedicamento();
        String getDosis();
    }

    @Query(value = "SELECT E.Nombre AS especialidad, COUNT(C.CitaID) AS totalCitas " +
            "FROM Citas C " +
            "JOIN Medicos M ON C.MedicoID = M.MedicoID " +
            "JOIN Especialidades E ON M.EspecialidadID = E.EspecialidadID " +
            "GROUP BY E.Nombre", nativeQuery = true)
    List<ICitasPorEspecialidadProjection> obtenerCitasPorEspecialidadNativo();

    interface ICitasPorEspecialidadProjection {
        String getEspecialidad();
        Long getTotalCitas();
    }

    @Query(value = "SELECT C.CitaID as citaID, C.FechaHora as fechaHora, C.Motivo as motivo, C.Estado as estado " +
                " FROM Citas C " +
                " JOIN Pacientes P ON C.PacienteID = P.PacienteID " +
                " WHERE P.DNI = :dniParam AND C.Estado = :estadoParam", nativeQuery = true)
    List<HistorialPacienteProjection> buscarPorDniYEstadoNativo(
            @Param("dniParam") String dni, 
            @Param("estadoParam") String estado
    );

    interface HistorialPacienteProjection {
        Integer getCitaID();
        LocalDateTime getFechaHora();
        String getMotivo();
        String getEstado();
    }
}


