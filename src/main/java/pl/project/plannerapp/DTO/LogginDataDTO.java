package pl.project.plannerapp.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Embeddable
public class LogginDataDTO {

    @Size(min = 3)
    private String string;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    public String getString() {
        return string;
    }

    public LogginDataDTO setString(String string) {
        this.string = string;
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
