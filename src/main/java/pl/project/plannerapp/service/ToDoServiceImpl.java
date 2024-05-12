package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.repo.ToDoRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepo toDoRepo;
    private final PersonalDataRepo personalDataRepo;

    @Autowired
    public ToDoServiceImpl(ToDoRepo toDoRepo, PersonalDataRepo personalDataRepo) {
        this.toDoRepo = toDoRepo;
        this.personalDataRepo = personalDataRepo;
    }

    @Override
    public List<ToDoDTO> getAll() {
        return null;
    }

    @Override
    public void add(ToDoDTO toDoDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<ToDoDTO> getById(Long id) {
        return Optional.empty();
    }
}
