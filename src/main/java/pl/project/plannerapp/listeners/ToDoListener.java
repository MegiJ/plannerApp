package pl.project.plannerapp.listeners;
//klasa zarządzana przez kontekst Springa

import org.springframework.stereotype.Component;
import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.events.ToDoCreator;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.service.ToDoService;
import pl.project.plannerapp.utils.PersonalDataConventerUtils;
import pl.project.plannerapp.utils.ToDoConventerUtils;
import pl.project.plannerapp.utils.TrainingConventerUtils;


@Component
public class ToDoListener {
    private final ToDoService toDoService;
    private final PersonalDataRepo personalDataRepo;

    public ToDoListener(ToDoService toDoService, PersonalDataRepo personalDataRepo) {
        this.toDoService = toDoService;
        this.personalDataRepo = personalDataRepo;
    }

    public void onAddToDo(ToDoCreator toDoCreator) {
        PersonalDataDTO personalDataDTO = toDoCreator.getPersonalDataDTO();

    }
}
