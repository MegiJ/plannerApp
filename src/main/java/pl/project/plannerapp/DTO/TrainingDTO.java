package pl.project.plannerapp.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

public class TrainingDTO {

    @NotNull
    private Instant date;

    @NotNull
    private String exercise;

    private PersonalData personalData;

    public Instant getDate() {
        return date;
    }

    public TrainingDTO setDate(Instant date) {
        this.date = date;
        return this;
    }

    public String getExercise() {
        return exercise;
    }

    public TrainingDTO setExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public TrainingDTO setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}
