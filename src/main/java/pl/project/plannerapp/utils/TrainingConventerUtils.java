package pl.project.plannerapp.utils;

import lombok.Builder;
import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.model.Training;

@Builder
public class TrainingConventerUtils {
    public static TrainingDTO convert (Training training) {
        return new TrainingDTOBuilder()
                .withId(training.getId())
                .withDate(training.getDate())
                .withExercise(training.getExercise())
                .withPersonalData(convert(training.getPersonalData()))
                .build();
    }

    public static Training convert (TrainingDTO trainingDTO) {
        return new TrainingBuilder()
                .withId(trainingDTO.getId())
                .withDate(trainingDTO.getDate())
                .withExercise(trainingDTO.getExercise())
                .withPersonalData(convert(trainingDTO.getPersonalData()))
                .build();
    }
}
