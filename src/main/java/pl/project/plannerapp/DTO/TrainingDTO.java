package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

public class TrainingDTO {
    public static class View {
        public interface Basic{}
        public interface Extended extends Basic {}
    }

    @JsonView(View.Basic.class)
    @NotNull
    private Instant date;

    @JsonView(View.Basic.class)
    @NotNull
    private String exercise;

    @JsonView(View.Extended.class)
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
