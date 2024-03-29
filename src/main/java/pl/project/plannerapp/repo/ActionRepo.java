package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.model.Action;

import java.util.Optional;

@Repository
public interface ActionRepo extends JpaRepository<Action, Integer> {
    Optional<Action> findById(int id);
}
