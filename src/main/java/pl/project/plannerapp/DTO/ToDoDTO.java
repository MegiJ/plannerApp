package pl.project.plannerapp.DTO;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.repo.model.PersonalData;

import java.time.Instant;

public class ToDoDTO {
    public static class View {
        public interface Basic{}
        public interface Extended extends Basic {}
    }

    @NotNull
    private Long id;

    @JsonView(View.Basic.class)
    @NotNull
    private String note;

    @JsonView(View.Basic.class)
    @NotNull
    private Instant date;

    @JsonView(View.Extended.class)
    private PersonalData personalData;

    public Long getId() {
        return id;
    }

    public ToDoDTO setId(Long id) {
        this.id = id;
        return this;
    }

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
