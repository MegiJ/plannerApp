package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

public class DietDTO {
    public static class View {
        public interface Basic {}
        public interface Extended extends Basic {}
    }

    @NotNull
    private Long id;

    @JsonView(View.Basic.class)
    @NotNull
    private Instant date;

    @JsonView(View.Basic.class)
    @NotNull
    private String meal;

    @JsonView(View.Extended.class)
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

    public Long getId() {
        return id;
    }

    public DietDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
