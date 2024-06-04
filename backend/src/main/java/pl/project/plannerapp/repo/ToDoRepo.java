package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.model.ToDo;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {

}
