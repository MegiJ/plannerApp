package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.plannerapp.model.ToDo;

import java.util.Optional;

public interface ToDoRepo extends JpaRepository {
    Optional<ToDo> findById(Long id);
}
