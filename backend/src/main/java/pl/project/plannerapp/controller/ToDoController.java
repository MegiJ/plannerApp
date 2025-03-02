package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.service.LoggingDataService;
import pl.project.plannerapp.service.ToDoService;
import pl.project.plannerapp.utils.ToDoConventerUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/api/todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ToDoController {
    private final ToDoService toDoService;
    private final LoggingDataService loggingDataService;

    @Autowired
    public ToDoController(ToDoService toDoService, LoggingDataService loggingDataService) {
        this.toDoService = toDoService;
        this.loggingDataService = loggingDataService;
    }

    @GetMapping
    public List<ToDoDTO> getAllTasks() {
        return toDoService.getAllTasks().stream().map(a -> ToDoConventerUtils.convert(a)).toList();
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
