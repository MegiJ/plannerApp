package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.base.Joiner;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Embeddable
@NoArgsConstructor
@Builder
public class PersonalDataDTO {
    public static class View {
        public interface Basic{}
        public interface Extended extends Basic {}
    }

    @NotNull
    private Long id;

    @JsonView(View.Basic.class)
    @NotNull
    private String firstname;

    @JsonView(View.Basic.class)
    @NotNull
    private String surname;

    @JsonView(View.Extended.class)
    @NotNull
    private int phone;

    @JsonView(View.Extended.class)
    @NotNull
    private String email;

    @JsonView(View.Basic.class)
    public String nameAndSurname() {
        return Joiner.on(" ").skipNulls().join(firstname, surname);
    }

    public Long getId() {
        return id;
    }

    public PersonalDataDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public PersonalDataDTO setFirstname(String firstname) {
        this.firstname = firstname;
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
