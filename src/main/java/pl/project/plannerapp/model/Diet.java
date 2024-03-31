package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class Diet {

    @Id
    @GeneratedValue
    private int d_id;

    @NotNull
    private Instant date;

    @NotNull
    private String meal;

    private PersonalData personalData;

    public int getD_id() {
        return d_id;
    }

    public Diet setD_id(int d_id) {
        this.d_id = d_id;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public Diet setDate(Instant date) {
        this.date = date;
        return this;
    }

    public String getMeal() {
        return meal;
    }

    public Diet setMeal(String meal) {
        this.meal = meal;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Diet setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}
