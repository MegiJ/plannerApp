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
import pl.project.plannerapp.utils.DietConventerUtils;

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
    public List<DietDTO> getAllDiets() {
        return dietService.getAllDiet().stream().map(a-> DietConventerUtils.convert(a)).toList();
    }

    @GetMapping("/{dietId}")
    public DietDTO getDietById(@PathVariable Long dietId) {
        return dietService.getById(dietId).map(a->DietConventerUtils.convert(a))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
//to tu
    @PostMapping("/{dietId}")
    public Long addDiet(@PathVariable Long dietId, @RequestBody DietDTO dietJson) {
        dietService.addDiet(DietConventerUtils.convert(dietJson));
        return dietId;
    }

    @Transactional
    @PutMapping("/{dietId}")
    public void modifyDiet(@PathVariable Long dietId, @RequestBody DietDTO dietJson) {

    }

    @Transactional
    @DeleteMapping("/{dietId}")
    public void delete(@PathVariable Long dietId) {
        
    }
}
