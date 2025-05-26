package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.DietDTORequest;
import pl.project.plannerapp.DTO.DietDTOResponse;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.Diet;


public class DietConventerUtils {
    public static DietDTOResponse convert(Diet diet) {
        return DietDTOResponse.builder()
                .id(diet.getDietId())
                .date(diet.getDate())
                .meal(diet.getMeal())
                .loggingDataId(diet.getLoggingDataId())
                .build();
    }

    public static Diet convert(DietDTORequest dietDTORequest) {
        return Diet.builder()
                .date(dietDTORequest.getDate())
                .meal(dietDTORequest.getMeal())
                .loggingDataId(dietDTORequest.getLoggingDataId())
                .build();
    }

    public static DietEntity convertToEntity(Diet dietToEntity, LoggingDataEntity loggingDataEntity) {
        return DietEntity.builder()
                .date(dietToEntity.getDate())
                .meal(dietToEntity.getMeal())
                .loggingDataEntity(loggingDataEntity)
                .build();
    }

    public static Diet convert(DietEntity dietEntity) {
        return Diet.builder()
                .dietId(dietEntity.getId())
                .date(dietEntity.getDate())
                .meal(dietEntity.getMeal())
                .loggingDataId(dietEntity.getLoggingDataEntity().getId())
                .build();
    }
}
