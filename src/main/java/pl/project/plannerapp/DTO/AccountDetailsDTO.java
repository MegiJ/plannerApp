package pl.project.plannerapp.DTO;

import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class AccountDetailsDTO {
    @NotNull
    private String role;

    @NotNull
    private boolean isExpired;

    @NotNull
    private boolean isLocked;

    @NotNull
    private boolean isCredentialsExpired;

    @NotNull
    private boolean idDisabled;


    public String getRole() {
        return role;
    }

    public AccountDetailsDTO setRole(String role) {
        this.role = role;
        return this;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public AccountDetailsDTO setExpired(boolean expired) {
        isExpired = expired;
        return this;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public AccountDetailsDTO setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }

    public boolean isCredentialsExpired() {
        return isCredentialsExpired;
    }

    public AccountDetailsDTO setCredentialsExpired(boolean credentialsExpired) {
        isCredentialsExpired = credentialsExpired;
        return this;
    }

    public boolean isIdDisabled() {
        return idDisabled;
    }

    public AccountDetailsDTO setIdDisabled(boolean idDisabled) {
        this.idDisabled = idDisabled;
        return this;
    }
}
