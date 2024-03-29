package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class ToDo {
    @Id
    @GeneratedValue
    private int td_id;

    @NotNull
    private String note;

    @NotNull
    private Instant date;

    private PersonalData personalData;

    public int getTd_id() {
        return td_id;
    }

    public ToDo setTd_id(int td_id) {
        this.td_id = td_id;
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
