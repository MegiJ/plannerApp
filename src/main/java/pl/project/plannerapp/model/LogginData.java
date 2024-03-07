package pl.project.plannerapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Embeddable
public class LogginData {
    @Column(unique = true)
    @Size(min = 3)
    private String string;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    public String getString() {
        return string;
    }

    public LogginData setString(String string) {
        this.string = string;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LogginData setPassword(String password) {
        this.password = password;
        return this;
    }
}
