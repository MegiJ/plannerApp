package pl.project.plannerapp.model;

import jakarta.persistence.Embeddable;

import javax.annotation.Nullable;

@Embeddable
public class PersonalData {

    @Nullable
    private String name;

    @Nullable
    private String surname;

    @Nullable
    private int phone;

    @Nullable
    private String email;

}
