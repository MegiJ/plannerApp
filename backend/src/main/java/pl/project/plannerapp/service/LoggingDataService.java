package pl.project.plannerapp.service;

import pl.project.plannerapp.model.LoggingData;

import java.util.List;
import java.util.Optional;

public interface LoggingDataService {
    List<LoggingData> getAllLoginData();

    Optional<LoggingData> getById(Long id);

    LoggingData saveNewLoggingData(LoggingData loggingData);

    LoggingData modifyPassword(Long loggingDataId, String newPassword);

    void delete(Long id);

}
