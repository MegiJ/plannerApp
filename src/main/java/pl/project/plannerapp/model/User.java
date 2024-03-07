package pl.project.plannerapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class User {

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
    private LogginData logginData;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public User setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public User setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    public LogginData getLogginData() {
        return logginData;
    }

    public User setLogginData(LogginData logginData) {
        this.logginData = logginData;
        return this;
    }
}
