package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.ToDoDTORequest;
import pl.project.plannerapp.DTO.ToDoDTOResponse;
import pl.project.plannerapp.model.ToDo;
import pl.project.plannerapp.service.ToDoService;
import pl.project.plannerapp.utils.ToDoConventerUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/api/todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDoDTOResponse> getAllTasks() {
        return toDoService.getAllTasks().stream().map(a -> ToDoConventerUtils.convert(a)).toList();
    }

    @PostMapping
    public Long addTask(@RequestBody ToDoDTORequest toDoJson) {
        ToDo tasksWithId = toDoService.addTask(ToDoConventerUtils.convert(toDoJson));
        return tasksWithId.getId();
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

    @DeleteMapping("/{todoId}")
    public void deleteToDo(@PathVariable Long todoId) {
        toDoService.deleteTask(todoId);
    }

}
