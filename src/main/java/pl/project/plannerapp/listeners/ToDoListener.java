package pl.project.plannerapp.listeners;
//klasa zarządzana przez kontekst Springa

import org.springframework.stereotype.Component;
import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.events.ToDoCreator;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.service.ToDoService;
import pl.project.plannerapp.utils.ToDoConventerUtils;

@Component
public class ToDoListener {
    private final ToDoService toDoService;
    private final LoggingDataRepo loggingDataRepo;

    public ToDoListener(ToDoService toDoService, LoggingDataRepo loggingDataRepo) {
        this.toDoService = toDoService;
        this.loggingDataRepo = loggingDataRepo;
    }

    public void onAddToDo(ToDoCreator toDoCreator) {
        LoggingDataDTO loggingDataDTO = toDoCreator.getLoggingDataDTO();
        ToDo toDo = ToDoConventerUtils.convert(loggingDataDT
    }
}
