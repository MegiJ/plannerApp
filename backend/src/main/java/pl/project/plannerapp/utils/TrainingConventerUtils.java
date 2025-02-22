package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.domain.TrainingEntity;
import pl.project.plannerapp.model.Training;


public class TrainingConventerUtils {
    public static TrainingDTO convert (Training training) {
        return TrainingDTO.builder()
                .id(training.getId())
                .date(training.getDate())
                .exercise(training.getExercise())
                .loggingDataDTO(LoggingDataConventerUtils.convert(training.getLoggingData()))
                .build();
    }

    public static Training convert (TrainingDTO trainingDTO) {
        return Training.builder()
                .id(trainingDTO.getId())
                .date(trainingDTO.getDate())
                .exercise(trainingDTO.getExercise())
                .loggingData(LoggingDataConventerUtils.convert(trainingDTO.getLoggingDataDTO()))
                .build();
    }

    public static TrainingEntity convertToEntity(Training trainingToEntity) {
        return TrainingEntity.builder()
                .date(trainingToEntity.getDate())
                .exercise(trainingToEntity.getExercise())
                .loggingDataEntity(LoggingDataConventerUtils.convertToEntity(trainingToEntity.getLoggingData()))
                .build();
    }

    public static Training convert (TrainingEntity trainingEntity) {
        return Training.builder()
                .id(trainingEntity.getId())
                .date(trainingEntity.getDate())
                .exercise(trainingEntity.getExercise())
                .loggingData(LoggingDataConventerUtils.convert(trainingEntity.getLoggingDataEntity()))
                .build();
    }
}
