package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.model.LoggingData;

public class LoggingDataConventerUtils {

    public static LoggingDataDTO convert(LoggingData loggingData) {
        return new LoggingDataDTOBuilder()
                .withId(loggingData.getId())
                .withLogin(loggingData.getLogin())
                .withPassword(loggingData.getPassword())
                .withPersonalData(convert(loggingData.getPersonalData()))
                .build();
    }

    public static LoggingDataConventerUtils convert(LoggingDataDTO loggingDataDTO) {
        return new LoggingDataBuilder()
                .withId(loggingDataDTO.getId())
                .withLogin(loggingDataDTO.getLogin())
                .withPassword(loggingDataDTO.getPassword())
                .withPrsonalData(convert(loggingDataDTO.getPersonalData()))
                .build();
    }
}
