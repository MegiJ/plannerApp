package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.ToDoEntity;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.ToDoRepo;
import pl.project.plannerapp.utils.ToDoConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepo toDoRepo;
    private final LoggingDataRepo loggingDataRepo;

    @Autowired
    public ToDoServiceImpl(ToDoRepo toDoRepo, LoggingDataRepo loggingDataRepo) {
        this.toDoRepo = toDoRepo;
        this.loggingDataRepo = loggingDataRepo;
    }

    @Override
    public List<ToDo> getAllTasks() {
        return toDoRepo.findAll()
                .stream()
                .map(ToDoConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ToDo addTask(ToDo toDoToBeAdded) {
        LoggingDataEntity loggingDataEntity = loggingDataRepo.findById(toDoToBeAdded.getLoggingDataId()).get();
        ToDoEntity saveNewTaskToDoEntity = toDoRepo.save(ToDoConventerUtils.convertToEntity(toDoToBeAdded, loggingDataEntity));
        ToDo toDoWithId = ToDoConventerUtils.convert(saveNewTaskToDoEntity);
        return toDoWithId;
    }

    @Override
    public boolean deleteTask(Long id) {
        ToDoEntity toDoEntity = toDoRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        toDoRepo.delete(toDoEntity);
        return true;
    }

    @Override
    public Optional<ToDo> getById(Long id) {
        return toDoRepo.findById(id)
                .map(ToDoConventerUtils::convert);
    }

    @Override
    public ToDo markTaskAsCompleted(Long id) {
        return null;
    }
}
