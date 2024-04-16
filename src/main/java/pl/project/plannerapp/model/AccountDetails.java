package pl.project.plannerapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class AccountDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String role;

    @NotNull
    private boolean isExpired;

    @NotNull
    private boolean isLocked;

    @NotNull
    private boolean isCredentialsExpired;

    public AccountDetails(Long id, String role, boolean isExpired, boolean isLocked, boolean isCredentialsExpired) {
        this.id = id;
        this.role = role;
        this.isExpired = isExpired;
        this.isLocked = isLocked;
        this.isCredentialsExpired = isCredentialsExpired;
    }

    public Long getId() {
        return id;
    }

    public AccountDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return role;
    }

    public AccountDetails setRole(String role) {
        this.role = role;
        return this;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public AccountDetails setExpired(boolean expired) {
        isExpired = expired;
        return this;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public AccountDetails setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }

    public boolean isCredentialsExpired() {
        return isCredentialsExpired;
    }

    public AccountDetails setCredentialsExpired(boolean credentialsExpired) {
        isCredentialsExpired = credentialsExpired;
        return this;
    }
}
