package pl.project.plannerapp.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@Embeddable
public class PersonalData {

    @NotNull
    private Long id;

    @NotNull
    private String firstname;

    @NotNull
    private String surname;

    @NotNull
    private int phone;

    @NotNull
    private String email;

    public Long getId() {
        return id;
    }

    public PersonalData setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public PersonalData setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonalData setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public PersonalData setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonalData setEmail(String email) {
        this.email = email;
        return this;
    }
}
