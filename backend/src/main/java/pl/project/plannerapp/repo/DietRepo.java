package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.model.Diet;

import java.util.Optional;

@Repository
public interface DietRepo extends JpaRepository<DietEntity, Long> {
    Optional<DietEntity> findById(Long id);
}
