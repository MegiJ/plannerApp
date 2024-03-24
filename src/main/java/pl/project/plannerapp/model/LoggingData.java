package pl.project.plannerapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@Embeddable
public class LoggingData {
    @Column(unique = true)
    @Size(min = 3)
    private String login;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    public String getLogin() {
        return login;
    }

    public LoggingData setLogin(String login) {
        this.login = login;
        return this;
    }

    private String getPassword() {
        return password;
    }

    private LoggingData setPassword(String password) {
        this.password = password;
        return this;
    }
}
