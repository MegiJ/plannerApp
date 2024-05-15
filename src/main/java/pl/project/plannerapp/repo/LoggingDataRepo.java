package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.repo.model.LoggingData;

import java.util.Optional;

@Repository
public interface LoggingDataRepo extends JpaRepository<LoggingData, Long> {
    Optional<LoggingData> findById(Long id);
}
