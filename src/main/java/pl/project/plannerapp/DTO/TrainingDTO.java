package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.model.PersonalData;
import pl.project.plannerapp.model.Training;

import java.time.Instant;

public class TrainingDTO {
    public static class View {
        public interface Basic{}
        public interface Extended extends Basic {}
    }

    @NotNull
    private Long id;

    @JsonView(View.Basic.class)
    @NotNull
    private Instant date;

    @JsonView(View.Basic.class)
    @NotNull
    private String exercise;

    @JsonView(View.Extended.class)
    private PersonalData personalData;

    public Long getId() {
        return id;
    }

    public TrainingDTO setId(Long id) {
        this.id = id;
        return this;
    }

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

    public TrainingDTO getPersonalData() {
        return this;
    }

    public TrainingDTO setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}
