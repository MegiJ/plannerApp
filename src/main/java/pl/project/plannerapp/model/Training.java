package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class Training {

    @Id
    @GeneratedValue
    private int t_id;

    @NotNull
    private Instant date;

    @NotNull
    private String exercise;

    private PersonalData personalData;



}
