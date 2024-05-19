package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.model.Training;

import java.util.Optional;

@Repository
public interface TrainingRepo  extends JpaRepository<Training, Integer> {

    Optional<Training> findById(Long id);
}
