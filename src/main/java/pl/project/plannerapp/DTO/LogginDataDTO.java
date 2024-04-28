package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@Embeddable
public class LogginDataDTO {
    public static class View {
        public interface Basic{}
        public interface Extended extends Basic {}
    }

    @JsonView(AccountDetailsDTO.View.Basic.class)
    @Size(min = 3)
    private String login;

    @JsonView(AccountDetailsDTO.View.Extended.class)
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    public String getLogin() {
        return login;
    }

    public LogginDataDTO setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LogginDataDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
