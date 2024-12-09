package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.domain.ToDoEntity;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.repo.ToDoRepo;
import pl.project.plannerapp.utils.ToDoConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepo toDoRepo;
    private final PersonalDataRepo personalDataRepo;
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public ToDoServiceImpl(ToDoRepo toDoRepo, PersonalDataRepo personalDataRepo, AccountDetailsRepo accountDetailsRepo) {
        this.toDoRepo = toDoRepo;
        this.personalDataRepo = personalDataRepo;
        this.accountDetailsRepo = accountDetailsRepo;
    }

    @Override
    public List<ToDo> getAllTasks() {
        return toDoRepo.findAll()
                .stream()
                .map(ToDoConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ToDo addTask(ToDo toDo) {
        AccountDetailsEntity accountDetailsEntity = accountDetailsRepo.findById(toDo.getPersonalData().getPersonalDataId()).get();
        toDoRepo.save(ToDoConventerUtils.convertToEntity(toDo, accountDetailsEntity));
        return toDo;
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
