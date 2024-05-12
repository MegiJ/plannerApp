package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.TrainingDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingService  {
    List<TrainingDTO> getAll();

    void add(TrainingDTO trainingDTO);

    void delete(Long id);

    Optional<TrainingDTO> getById(Long id);
}
