package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    interface ToDoView extends ToDoDTO.View.Basic {}
    private final ToDoService toDoService;
    private final PersonalDataService personalDataService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public ToDoController(ToDoService toDoService, PersonalDataService personalDataService, ApplicationEventPublisher applicationEventPublisher) {
        this.toDoService = toDoService;
        this.personalDataService = personalDataService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    @DeleteMapping("/{todo-id}")
    public void delete(@PathVariable Long id) {

    }
    @PostMapping
    public ResponseEntity<ToDo> addTask(@RequestBody ToDoDTO toDoDTO) {
        ToDo newToDo = toDoService.addTask(ToDoConventerUtils.convert(toDoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(newToDo);
    }

    @PatchMapping("/{todo-id}/complete")
    public ResponseEntity<ToDo> markTaskAsCompleted(@PathVariable Long toDoId) { // zaznacz zadanie jako ukonczone
        ToDo completedTask = toDoService.markTaskAsCompleted(toDoId);
        return ResponseEntity.ok(completedTask);
    }

    @GetMapping
    public ResponseEntity<List<ToDoDTO>> getAllTasks() {
        List<ToDoDTO> tasks = toDoService.getAllTasks();
        return ResponseEntity.ok(tasks);
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
