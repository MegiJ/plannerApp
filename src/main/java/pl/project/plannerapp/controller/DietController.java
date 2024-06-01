package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.service.DietService;
import pl.project.plannerapp.service.PersonalDataService;

import java.util.List;

@Validated
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
        return dietService.getAllDiet();
    }

    @GetMapping("/{diet-id}")
    public DietDTO get(@PathVariable Long id) {
        return dietService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @PutMapping("/{diet-id}")
    public void put(@PathVariable Long id, @RequestBody DietDTO dietJson) {

    }

    @Transactional
    @DeleteMapping("/{diet-id}")
    public void delete(@PathVariable Long id) {
        
    }
}
