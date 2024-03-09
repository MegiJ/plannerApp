package pl.project.plannerapp.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Obligation {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String note;

    @NotNull
    @Embedded
    private User user;

    @NotNull
    private boolean accountStatus;
}
