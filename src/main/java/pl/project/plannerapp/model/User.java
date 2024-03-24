package pl.project.plannerapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @NotNull
    private String accountType;

    @NotNull
    @Embedded
    private PersonalData personalData;

    @NotNull
    @Embedded
    private LoggingData loggingData;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public User setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    public LoggingData getLoggingData() {
        return loggingData;
    }

    public User setLoggingData(LoggingData loggingData) {
        this.loggingData = loggingData;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public User setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public User setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }
}
