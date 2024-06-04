package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.domain.ToDoEntity;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.model.Training;

import java.util.Optional;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoEntity, Long> {
    Optional<ToDoEntity> findById(Long id);

}
