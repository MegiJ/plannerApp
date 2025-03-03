package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.TrainingEntity;
import pl.project.plannerapp.model.Training;


public class TrainingConventerUtils {
    public static TrainingDTO convert (Training training) {
        return TrainingDTO.builder()
                .id(training.getId())
                .date(training.getDate())
                .exercise(training.getExercise())
                .build();
    }

    public static Training convert (TrainingDTO trainingDTO) {
        return Training.builder()
                .id(trainingDTO.getId())
                .date(trainingDTO.getDate())
                .exercise(trainingDTO.getExercise())
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
