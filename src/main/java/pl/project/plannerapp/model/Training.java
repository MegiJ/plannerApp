package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.Instant;

@Builder
public class Training {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Instant date;

    @NotNull
    private String exercise;

    private PersonalData personalData;

    public Long getId() {
        return id;
    }

    public Training setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public Training setDate(Instant date) {
        this.date = date;
        return this;
    }

    public String getExercise() {
        return exercise;
    }

    public Training setExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    public Training getPersonalData() {
        return getPersonalData();
    }

    public Training setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

}
