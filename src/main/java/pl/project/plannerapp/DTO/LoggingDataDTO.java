package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.model.LoggingData;
import pl.project.plannerapp.model.PersonalData;

@GeneratePojoBuilder
@Embeddable
public class LoggingDataDTO {
    public static class View {
        public interface Basic{}
        public interface Extended extends Basic {}
    }

    @NotNull
    private Long id;

    @JsonView(AccountDetailsDTO.View.Basic.class)
    @Size(min = 3)
    private String login;

    @JsonView(AccountDetailsDTO.View.Extended.class)
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    private PersonalData personalData;

    private AccountDetails accountDetails;

    public PersonalData getPersonalData() {
        return personalData;
    }

    public LoggingDataDTO setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public LoggingDataDTO setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public LoggingDataDTO setLogin(String login) {
        this.login = login;
        return this;
    }

    public Long getId() {
        return id;
    }

    public LoggingDataDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoggingDataDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
