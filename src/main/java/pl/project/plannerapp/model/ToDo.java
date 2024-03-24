package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class ToDo {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String note;
}
