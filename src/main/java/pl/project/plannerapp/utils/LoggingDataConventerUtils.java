package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.model.LoggingData;


public class LoggingDataConventerUtils {
    public static LoggingDataDTO convert(LoggingData loggingData) {
        return LoggingDataDTO.builder()
                .id(loggingData.getId())
                .login(loggingData.getLogin())
                .password(loggingData.getPassword())
                .personalDataDTO(PersonalDataConventerUtils.convert(loggingData.getPersonalData()))
                .accountDetailsDTO(AccountDetailsConventerUtils.convert(loggingData.getAccountDetails()))
                .build();
    }
    public static LoggingData convert(LoggingDataDTO loggingDataDTO) {
        return LoggingData.builder()
                .id(loggingDataDTO.getId())
                .login(loggingDataDTO.getLogin())
                .password(loggingDataDTO.getPassword())
                .personalData(PersonalDataConventerUtils.convert(loggingDataDTO.getPersonalDataDTO()))
                .accountDetails(AccountDetailsConventerUtils.convert(loggingDataDTO.getAccountDetailsDTO()))
                .build();
    }
}
