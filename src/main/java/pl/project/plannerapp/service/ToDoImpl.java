package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.repo.ToDoRepo;

@Service
public class ToDoImpl implements ToDoService {
    private final ToDoRepo toDoRepo;
    private final PersonalDataRepo personalDataRepo;

    @Autowired
    public ToDoImpl(ToDoRepo toDoRepo, PersonalDataRepo personalDataRepo) {
        this.toDoRepo = toDoRepo;
        this.personalDataRepo = personalDataRepo;
    }
}
