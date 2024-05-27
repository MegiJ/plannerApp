package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.Instant;

@Builder
public class ToDo {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String note;

    @NotNull
    private Instant date;

    private PersonalData personalData;

    public int getId() {
        return id;
    }

    public ToDo setId(int id) {
        this.id = id;
        return this;
    }

    public String getNote() {
        return note;
    }

    public ToDo setNote(String note) {
        this.note = note;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public ToDo setDate(Instant date) {
        this.date = date;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ToDo setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}
