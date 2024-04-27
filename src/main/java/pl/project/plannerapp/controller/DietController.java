package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.service.DietService;
import pl.project.plannerapp.service.PersonalDataService;
import pl.project.plannerapp.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/diets", produces = MediaType.APPLICATION_JSON_VALUE)
public class DietController {
    private final DietService dietService;
    private final PersonalDataService personalDataService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public DietController(DietService dietService, PersonalDataService personalDataService, ApplicationEventPublisher applicationEventPublisher) {
        this.dietService = dietService;
        this.personalDataService = personalDataService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping
    public List<DietDTO> get() {
        return null;
    }

    @GetMapping("/{diet-id}")
    public DietDTO get(@PathVariable int id) {
        return null;
    }

    @Transactional
    @PutMapping("/{diet-id}")
    public void put(@PathVariable int id, @RequestBody DietDTO dietJson) {

    }

    @Transactional
    @DeleteMapping("/{diet-id}")
    public void delete(@PathVariable int id) {
        
    }
}
