package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.model.LoggingData;

public class LoggingDataUtils {

    public static LoggingDataDTO convert(LoggingData loggingData) {
        return new LoggingDataDTOBuilder()
                .withId(loggingData.getId())
                .withLogin(loggingData.getLogin())
                .withPassword(loggingData.getPassword())
                .withPersonalData(convert(loggingData.getPersonalData()))
                .build();
    }

    public static LoggingDataUtils convert(LoggingDataDTO loggingDataDTO) {
        return new LoggingDataBuilder()
                .withLogin(loggingDataDTO.getLogin())
                .withPassword(loggingDataDTO.getPassword())
                .build();
    }
}
