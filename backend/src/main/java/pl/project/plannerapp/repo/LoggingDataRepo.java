package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.LoggingData;

import java.util.Optional;

@Repository
public interface LoggingDataRepo extends JpaRepository<LoggingDataEntity, Long> {
    Optional<LoggingDataEntity> findById(Long id);
}
