package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.service.PersonalDataService;
import pl.project.plannerapp.service.ToDoService;
import pl.project.plannerapp.service.TrainingService;

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

    @GetMapping
    public List<ToDoDTO> get() {
        return null;
    }

    @GetMapping("/{todo-id}")
    public ToDoDTO get(@PathVariable int id) {
        return null;
    }

    @Transactional
    @PutMapping("/{todo-id}")
    public void put(@PathVariable int id, @RequestBody ToDoDTO toDoJson) {

    }

    @Transactional
    @DeleteMapping("/{todo-id}")
    public void delete(@PathVariable int id) {

    }
}
