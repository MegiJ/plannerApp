package pl.project.plannerapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @NotNull
    @Embedded
    private PersonalData personalData;

    @NotNull
    @Embedded
    private LoginData loginData;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Employee setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Employee setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    public LoginData getLoginData() {
        return loginData;
    }

    public Employee setLoginData(LoginData loginData) {
        this.loginData = loginData;
        return this;
    }
}
