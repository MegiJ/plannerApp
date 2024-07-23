package pl.project.plannerapp.service;

import pl.project.plannerapp.model.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService  {
    List<Training> getAllTraining();

    Training addExercise(Training training);

    boolean deleteExercise(Long id);

    Optional<Training> getById(Long id);
}
