package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.DTO.TrainingDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingService  {
    List<TrainingDTO> getAll();

    void put (Long id, TrainingDTO trainingDTO);

    void delete(Long id);

    Optional<TrainingDTO> getById(Long id);
}
