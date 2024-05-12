package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.ToDoDTO;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    List<ToDoDTO> getAll();

    void add(ToDoDTO toDoDTO);

    void delete(Long id);

    Optional<ToDoDTO> getById(Long id);
}
