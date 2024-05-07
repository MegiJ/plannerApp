package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class AccountDetailsDTO {
    public static class View {
        public interface Basic{}
        public interface Extended extends Basic {}
    }

    @NotNull
    private Long id;

    @JsonView(View.Basic.class)
    @NotNull
    private String role;

    @JsonView(View.Basic.class)
    @NotNull
    private boolean isExpired;

    @JsonView(View.Basic.class)
    @NotNull
    private boolean isLocked;

    @JsonView(View.Extended.class)
    @NotNull
    private boolean isCredentialsExpired;

    @JsonView(View.Extended.class)
    @NotNull
    private boolean idDisabled;

    public Long getId() {
        return id;
    }

    public AccountDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

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
