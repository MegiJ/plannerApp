package pl.project.plannerapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class Dashboards {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @NotNull
    @Embedded
    private String nameDashboard;
}
