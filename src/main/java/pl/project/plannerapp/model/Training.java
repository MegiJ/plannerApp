package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class Training {

    @Id
    @GeneratedValue
    private int t_id;

    @NotNull
    private Instant date;

    @NotNull
    private String exercise;

    private PersonalData personalData;

    public int getT_id() {
        return t_id;
    }

    public Training setT_id(int t_id) {
        this.t_id = t_id;
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

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Training setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}