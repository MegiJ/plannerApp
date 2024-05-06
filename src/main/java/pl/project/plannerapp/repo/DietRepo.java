package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.plannerapp.model.Diet;

import java.util.Optional;

public interface DietRepo extends JpaRepository<Diet, Integer> {
    Optional<Diet> findById(Long id);
}
