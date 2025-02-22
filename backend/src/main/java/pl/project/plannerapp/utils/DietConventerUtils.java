package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.DietDTORequest;
import pl.project.plannerapp.DTO.DietDTOResponse;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.model.LoggingData;


public class DietConventerUtils {
    public static DietDTOResponse convert(Diet diet) {
        return DietDTOResponse.builder()
                .id(diet.getDietId())
                .date(diet.getDate())
                .meal(diet.getMeal())
                .loggingDataDTO(LoggingDataConventerUtils.convert(diet.getLoggingData()))
//                .personalDataDTO(PersonalDataConventerUtils.convert(diet.getPersonalData()))
                .build();
    }

    public static Diet convert(DietDTOResponse dietDTOResponse) {
        return Diet.builder()
                .dietId(dietDTOResponse.getId())
                .date(dietDTOResponse.getDate())
                .meal(dietDTOResponse.getMeal())
                .loggingData(LoggingDataConventerUtils.convert(dietDTOResponse.getLoggingDataDTO()))
//                .personalData(PersonalDataConventerUtils.convert(dietDTOResponse.getPersonalDataDTO()))
                .build();
    }

    public static Diet convert(DietDTORequest dietDTORequest) {
        return Diet.builder()
                .date(dietDTORequest.getDate())
                .meal(dietDTORequest.getMeal())
                .loggingData(LoggingData.builder().build())
                .loggingData(LoggingData.builder().id(dietDTORequest.getLoggingDataId()).build())
//                .personalData(PersonalData.builder().personalDataId(dietDTORequest.getPersonalDataId()).build())
                .build();
    }

    public static DietEntity convertToEntity(Diet dietToEntity) {
        return DietEntity.builder()
                .date(dietToEntity.getDate())
                .meal(dietToEntity.getMeal())
//                .personalDataEntity(PersonalDataConventerUtils.convertToEntity(dietToEntity.getPersonalData(), accountDetailsEntity))
                .loggingDataEntity(LoggingDataConventerUtils.convertToEntity(dietToEntity.getLoggingData()))
                .build();
    }

    public static Diet convert(DietEntity dietEntity) {
        return Diet.builder()
                .dietId(dietEntity.getId())
                .date(dietEntity.getDate())
                .meal(dietEntity.getMeal())
                .loggingData(LoggingDataConventerUtils.convert(dietEntity.getLoggingDataEntity()))
//                .personalData(PersonalDataConventerUtils.convert(dietEntity.getPersonalDataEntity()))
                .build();
    }
}
