package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.service.PersonalDataService;
import pl.project.plannerapp.service.ToDoService;
import pl.project.plannerapp.utils.ToDoConventerUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/api/todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ToDoController {
    private final ToDoService toDoService;
    private final PersonalDataService personalDataService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public ToDoController(ToDoService toDoService, PersonalDataService personalDataService, ApplicationEventPublisher applicationEventPublisher) {
        this.toDoService = toDoService;
        this.personalDataService = personalDataService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @DeleteMapping("/{todoId}")
    public void deleteToDo(@PathVariable Long todoId) {
        toDoService.deleteTask(todoId);
    }
    @PostMapping
    public ResponseEntity<ToDo> addTask(@RequestBody ToDoDTO toDoDTO) {
        ToDo newToDo = toDoService.addTask(ToDoConventerUtils.convert(toDoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(newToDo);
    }

    @PatchMapping("/{todoId}/complete")
    public ResponseEntity<ToDo> markTaskAsCompleted(@PathVariable Long toDoId) { // zaznacz zadanie jako ukonczone
        ToDo completedTask = toDoService.markTaskAsCompleted(toDoId);
        return ResponseEntity.ok(completedTask);
    }

    @GetMapping
    public List<ToDoDTO> getAllTasks() {
        List<ToDo> tasks = toDoService.getAllTasks();
        return tasks.stream().map(ToDoConventerUtils::convert).toList();
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity<ToDo> deleteTask(@PathVariable Long taskId) {
        boolean deletedTask = toDoService.deleteTask(taskId);
        if (deletedTask) {
            return ResponseEntity.status('1').build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
