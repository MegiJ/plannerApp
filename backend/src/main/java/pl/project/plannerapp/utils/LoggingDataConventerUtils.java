package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.LoggingData;


public class LoggingDataConventerUtils {
    public static LoggingDataDTO convert(LoggingData loggingData) {
        return LoggingDataDTO.builder()
                .login(loggingData.getLogin())
                .password(loggingData.getPassword())
                .build();
    }

    public static LoggingData convert(LoggingDataDTO loggingDataDTO) {
        return LoggingData.builder()
                .login(loggingDataDTO.getLogin())
                .password(loggingDataDTO.getPassword())
                .build();
    }

    public static LoggingDataEntity convertToEntity(LoggingData loggingDataToEntity) {
        return LoggingDataEntity.builder()
                .login(loggingDataToEntity.getLogin())
                .password(loggingDataToEntity.getPassword())
                .accountDetailsEntity(AccountDetailsConventerUtils.convertToEntity(loggingDataToEntity.getAccountDetails()))
                .build();
    }

    public static LoggingData convert(LoggingDataEntity loggingDataEntity) {
        return LoggingData.builder()
                .id(loggingDataEntity.getId())
                .login(loggingDataEntity.getLogin())
                .password(loggingDataEntity.getPassword())
                .accountDetails(AccountDetailsConventerUtils.convert(loggingDataEntity.getAccountDetailsEntity()))
                .build();
    }
}
