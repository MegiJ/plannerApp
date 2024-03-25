package pl.project.plannerapp.DTO;
import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

public class ToDoDTO {

    @NotNull
    private String note;

    @NotNull
    private Instant date;

    private PersonalData personalData;

    public String getNote() {
        return note;
    }

    public ToDoDTO setNote(String note) {
        this.note = note;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public ToDoDTO setDate(Instant date) {
        this.date = date;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ToDoDTO setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}
