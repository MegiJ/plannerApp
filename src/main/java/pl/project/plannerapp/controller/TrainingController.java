package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.service.PersonalDataService;
import pl.project.plannerapp.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/trainings", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingController {
    private final TrainingService trainingService;
    private final PersonalDataService personalDataService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public TrainingController(TrainingService trainingService, PersonalDataService personalDataService, ApplicationEventPublisher applicationEventPublisher) {
        this.trainingService = trainingService;
        this.personalDataService = personalDataService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping
    public List<TrainingDTO> get() {
        return null;
    }

    @GetMapping("/{training-id}")
    public TrainingDTO get(@PathVariable Long id) {
        return null;
    }

    @Transactional
    @PutMapping("/{training-id}")
    public void put(@PathVariable Long id, @RequestBody TrainingDTO trainingJson) {

    }

    @Transactional
    @DeleteMapping("/{training-id}")
    public void delete(@PathVariable Long id) {

    }
}
