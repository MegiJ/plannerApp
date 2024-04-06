package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.plannerapp.model.Training;

import java.util.Optional;

public interface TrainingRepo  extends JpaRepository<Training, Integer> {

    Optional<Training> findById(Integer integer);
}