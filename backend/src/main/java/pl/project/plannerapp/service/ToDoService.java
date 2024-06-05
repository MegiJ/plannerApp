package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    List<ToDo> getAllTasks();

    ToDo addTask(ToDo toDo);

    boolean deleteTask(Long id);

    Optional<ToDoDTO> getById(Long id);

    ToDo markTaskAsCompleted(Long id);
}
