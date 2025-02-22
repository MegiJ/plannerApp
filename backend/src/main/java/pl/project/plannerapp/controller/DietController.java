package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.DietDTORequest;
import pl.project.plannerapp.DTO.DietDTOResponse;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.service.DietService;
import pl.project.plannerapp.service.LoggingDataService;
import pl.project.plannerapp.utils.DietConventerUtils;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/api/diets", produces = MediaType.APPLICATION_JSON_VALUE)
public class DietController {
    private final DietService dietService;
    //    private final PersonalDataService personalDataService;
    private final LoggingDataService loggingDataService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public DietController(DietService dietService, LoggingDataService loggingDataService, ApplicationEventPublisher applicationEventPublisher) {
        this.dietService = dietService;
//        this.personalDataService = personalDataService;
        this.loggingDataService = loggingDataService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping
    public List<DietDTOResponse> getAllDiets() {
        return dietService.getAllDiet().stream().map(a -> DietConventerUtils.convert(a)).toList();
    }

    @GetMapping("/{dietId}")
    public DietDTOResponse getDietById(@PathVariable Long dietId) {
        return dietService.getById(dietId).map(a -> DietConventerUtils.convert(a))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Long addDiet(@RequestBody DietDTORequest dietJson) {
        Diet dietWithId = dietService.addDiet(DietConventerUtils.convert(dietJson));
        return dietWithId.getDietId();
    }

    @Transactional
    @PutMapping("/{dietId}")
    public void modifyDiet(@PathVariable Long dietId, @RequestBody DietDTOResponse dietJson) {

    }

    @Transactional
    @DeleteMapping("/{dietId}")
    public void delete(@PathVariable Long dietId) {
        
    }
}
