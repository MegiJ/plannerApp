package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.LoggingDataDTO;

import java.util.List;
import java.util.Optional;

public interface LoggingDataService {
    List<LoggingDataDTO> getAllLoginData();

    void put (Long id, LoggingDataDTO loggingDataDTO);

    void delete(Long id);

    Optional<LoggingDataDTO> getById(Long id);

}
