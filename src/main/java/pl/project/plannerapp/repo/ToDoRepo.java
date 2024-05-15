package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.repo.model.ToDo;

import java.util.Optional;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {

    Optional<ToDo> findById(Long id);
}
