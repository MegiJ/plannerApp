package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Embeddable
@NoArgsConstructor
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

    private PersonalDataDTO personalDataDTO;

    private AccountDetailsDTO accountDetailsDTO;

    public Long getId() {
        return id;
    }

    public LoggingDataDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public LoggingDataDTO setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoggingDataDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public PersonalDataDTO getPersonalDataDTO() {
        return personalDataDTO;
    }

    public LoggingDataDTO setPersonalDataDTO(PersonalDataDTO personalDataDTO) {
        this.personalDataDTO = personalDataDTO;
        return this;
    }

    public AccountDetailsDTO getAccountDetailsDTO() {
        return accountDetailsDTO;
    }

    public LoggingDataDTO setAccountDetailsDTO(AccountDetailsDTO accountDetailsDTO) {
        this.accountDetailsDTO = accountDetailsDTO;
        return this;
    }
}
