package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.TrainingDTORequest;
import pl.project.plannerapp.DTO.TrainingDTOResposne;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.TrainingEntity;
import pl.project.plannerapp.model.Training;


public class TrainingConventerUtils {
    public static TrainingDTOResposne convert(Training training) {
        return TrainingDTOResposne.builder()
                .id(training.getId())
                .date(training.getDate())
                .exercise(training.getExercise())
                .loggingDataId(training.getLoggingDataId())
                .build();
    }

    public static Training convert(TrainingDTOResposne trainingDTOResposne) {
        return Training.builder()
                .id(trainingDTOResposne.getId())
                .date(trainingDTOResposne.getDate())
                .exercise(trainingDTOResposne.getExercise())
                .loggingDataId(trainingDTOResposne.getLoggingDataId())
                .build();
    }

    public static Training convert(TrainingDTORequest trainingDTORequest) {
        return Training.builder()
                .date(trainingDTORequest.getDate())
                .exercise(trainingDTORequest.getExercise())
                .loggingDataId(trainingDTORequest.getLoggingDataId())
                .build();
    }

    public static TrainingEntity convertToEntity(Training trainingToEntity, LoggingDataEntity loggingDataEntity) {
        return TrainingEntity.builder()
                .date(trainingToEntity.getDate())
                .exercise(trainingToEntity.getExercise())
                .loggingDataEntity(loggingDataEntity)
                .build();
    }

    public static Training convert (TrainingEntity trainingEntity) {
        return Training.builder()
                .id(trainingEntity.getId())
                .date(trainingEntity.getDate())
                .exercise(trainingEntity.getExercise())
                .loggingDataId(trainingEntity.getLoggingDataEntity().getId())
                .build();
    }
}
