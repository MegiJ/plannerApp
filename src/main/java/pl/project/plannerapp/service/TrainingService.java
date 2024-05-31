package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.model.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService  {
    List<TrainingDTO> getAllTraining();

    Training addExercise(Training training);

    boolean deleteExercise(Long id);

    Optional<TrainingDTO> getById(Long id);
}
