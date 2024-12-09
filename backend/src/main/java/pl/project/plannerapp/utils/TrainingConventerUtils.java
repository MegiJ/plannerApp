package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.domain.TrainingEntity;
import pl.project.plannerapp.model.Training;


public class TrainingConventerUtils {
    public static TrainingDTO convert (Training training) {
        return TrainingDTO.builder()
                .id(training.getId())
                .date(training.getDate())
                .exercise(training.getExercise())
                .personalDataDTO(PersonalDataConventerUtils.convert(training.getPersonalData()))
                .build();
    }

    public static Training convert (TrainingDTO trainingDTO) {
        return Training.builder()
                .id(trainingDTO.getId())
                .date(trainingDTO.getDate())
                .exercise(trainingDTO.getExercise())
                .personalData(PersonalDataConventerUtils.convert(trainingDTO.getPersonalDataDTO()))
                .build();
    }

    public static TrainingEntity convertToEntity(Training training, AccountDetailsEntity accountDetailsEntity) {
        return TrainingEntity.builder()
                .date(training.getDate())
                .exercise(training.getExercise())
                .personalDataEntity(PersonalDataConventerUtils.convertToEntity(training.getPersonalData(), accountDetailsEntity))
                .build();
    }

    public static Training convert (TrainingEntity trainingEntity) {
        return Training.builder()
                .id(trainingEntity.getId())
                .date(trainingEntity.getDate())
                .exercise(trainingEntity.getExercise())
                .personalData(PersonalDataConventerUtils.convert(trainingEntity.getPersonalDataEntity()))
                .build();
    }
}
