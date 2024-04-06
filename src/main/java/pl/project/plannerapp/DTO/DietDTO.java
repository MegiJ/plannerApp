package pl.project.plannerapp.DTO;

import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

public class DietDTO {
    @NotNull
    private Instant date;

    @NotNull
    private String meal;

    private PersonalData personalData;

    public Instant getDate() {
        return date;
    }

    public DietDTO setDate(Instant date) {
        this.date = date;
        return this;
    }

    public String getMeal() {
        return meal;
    }

    public DietDTO setMeal(String meal) {
        this.meal = meal;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public DietDTO setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}