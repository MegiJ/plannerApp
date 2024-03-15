package pl.project.plannerapp.DTO;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@Embeddable
public class PersonalDataDTO {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private int phone;

    @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public PersonalDataDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonalDataDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public PersonalDataDTO setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonalDataDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
