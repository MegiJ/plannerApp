package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.time.Instant;

@GeneratePojoBuilder
public class Diet {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Instant date;

    @NotNull
    private String meal;

    private PersonalData personalData;

    public Long getId() {
        return id;
    }

    public Diet setId(Long id) {
        this.id = id;
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

    public Diet getPersonalData() {
        return this;
    }

    public Diet setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}
