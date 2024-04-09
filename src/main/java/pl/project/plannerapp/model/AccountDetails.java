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

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @NotNull
    private String accountType;

    @NotNull
    private boolean isExpired;

    @NotNull
    private boolean isBlocked;

    public Long getId() {
        return id;
    }

    public AccountDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public AccountDetails setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public AccountDetails setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public AccountDetails setExpired(boolean expired) {
        isExpired = expired;
        return this;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public AccountDetails setBlocked(boolean blocked) {
        isBlocked = blocked;
        return this;
    }
}
