package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.model.LoggingData;

import java.util.List;
import java.util.Optional;

public interface LoggingDataService {
    List<LoggingData> getAllLoginData();

    void put (Long id, LoggingDataDTO loggingDataDTO);

    void delete(Long id);

    Optional<LoggingData> getById(Long id);

}
