package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.TrainingDTORequest;
import pl.project.plannerapp.DTO.TrainingDTOResposne;
import pl.project.plannerapp.model.Training;
import pl.project.plannerapp.service.TrainingService;
import pl.project.plannerapp.utils.TrainingConventerUtils;

import java.util.List;

@Validated
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
        return trainingService.getAllTraining().stream()
                .map(TrainingConventerUtils::convert)
                .toList();
    }

    @GetMapping("/{trainingId}")
    public TrainingDTOResposne getTrainingById(@PathVariable Long trainingId) {
        return trainingService.getById(trainingId).map(a -> TrainingConventerUtils.convert(a))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Long addExercise(@RequestBody TrainingDTORequest trainingJson) {
        Training trainigWithId = trainingService.addExercise(TrainingConventerUtils.convert(trainingJson));
        return trainigWithId.getId();
    }

    @PutMapping("/{trainingId}")
    public void put(@PathVariable Long id, @RequestBody TrainingDTOResposne trainingJson) {

    }


    @DeleteMapping("/{trainingId}")
    public ResponseEntity<Long> delete(@PathVariable Long trainingId) {
        trainingService.deleteExercise(trainingId);
        return new ResponseEntity<>(trainingId, HttpStatus.OK);
    }
}
