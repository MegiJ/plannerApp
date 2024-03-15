package pl.project.plannerapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class User {

    @Id
    @GeneratedValue
    private Long id;

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
