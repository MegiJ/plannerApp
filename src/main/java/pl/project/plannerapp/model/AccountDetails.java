package pl.project.plannerapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import net.karneim.pojobuilder.GeneratePojoBuilder;


@GeneratePojoBuilder
@Builder
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

    @NotNull
    private boolean isDisabled;

    public AccountDetails(Long id, String role, boolean isExpired, boolean isLocked, boolean isCredentialsExpired, boolean isDisabled) {
        this.id = id;
        this.role = role;
        this.isExpired = isExpired;
        this.isLocked = isLocked;
        this.isCredentialsExpired = isCredentialsExpired;
        this.isDisabled = isDisabled;
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

    public boolean isDisabled() {
        return isDisabled;
    }

    public AccountDetails setDisabled(boolean disabled) {
        isDisabled = disabled;
        return this;
    }
}
