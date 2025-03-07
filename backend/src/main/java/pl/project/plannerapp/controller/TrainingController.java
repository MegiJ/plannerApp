package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.TrainingDTORequest;
import pl.project.plannerapp.DTO.TrainingDTOResposne;
import pl.project.plannerapp.model.Training;
import pl.project.plannerapp.service.TrainingService;
import pl.project.plannerapp.utils.TrainingConventerUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/api/trainings", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingController {
    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public List<TrainingDTOResposne> getAllTrainings() {
        return trainingService.getAllTraining().stream().map(a -> TrainingConventerUtils.convert(a)).toList();
    }

    @PostMapping
    public Long addExercise(@RequestBody TrainingDTORequest trainingJson) {
        Training trainigWithId = trainingService.addExercise(TrainingConventerUtils.convert(trainingJson));
        return trainigWithId.getId();
    }

    @Transactional
    @PutMapping("/{trainingId}")
    public void put(@PathVariable Long id, @RequestBody TrainingDTOResposne trainingJson) {

    }

    @GetMapping("/{trainingId}")
    public TrainingDTOResposne getTrainingById(@PathVariable Long trainingId) {
        return trainingService.getById(trainingId).map(a -> TrainingConventerUtils.convert(a))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @DeleteMapping("/{trainingId}")
    public void delete(@PathVariable Long id) {

    }
}
