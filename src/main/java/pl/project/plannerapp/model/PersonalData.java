package pl.project.plannerapp.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@Embeddable
public class PersonalData {

    @NotNull
    private int pd_id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private int phone;

    @NotNull
    private String email;

    public int getPd_id() {
        return pd_id;
    }

    public PersonalData setPd_id(int pd_id) {
        this.pd_id = pd_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonalData setName(String name) {
        this.name = name;
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
