package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.LoggingDataDTORequest;
import pl.project.plannerapp.DTO.LoggingDataDTOResponse;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.LoggingData;


public class LoggingDataConventerUtils {
    public static LoggingDataDTOResponse convert(LoggingData loggingData) {
        return LoggingDataDTOResponse.builder()
                .login(loggingData.getLogin())
                .password(loggingData.getPassword())
                .accountDetailsId(loggingData.getAccountDetailsId())
                .build();
    }

    public static LoggingData convert(LoggingDataDTORequest loggingDataDTO) {
        return LoggingData.builder()
                .login(loggingDataDTO.getLogin())
                .password(loggingDataDTO.getPassword())
                .build();
    }

    public static LoggingDataEntity convertToEntity(LoggingData loggingDataToEntity, AccountDetailsEntity accountDetailsEntity) {
        return LoggingDataEntity.builder()
                .login(loggingDataToEntity.getLogin())
                .password(loggingDataToEntity.getPassword())
                .accountDetailsEntity(accountDetailsEntity)
                .build();
    }

    public static LoggingData convert(LoggingDataEntity loggingDataEntity) {
        return LoggingData.builder()
                .loggingDataId(loggingDataEntity.getId())
                .login(loggingDataEntity.getLogin())
                .password(loggingDataEntity.getPassword())
                .accountDetailsId(loggingDataEntity.getAccountDetailsEntity().getId())
                .build();
    }
}
