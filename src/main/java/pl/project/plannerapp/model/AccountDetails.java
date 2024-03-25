package pl.project.plannerapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class AccountDetails {

    @Id
    @GeneratedValue
    private Long ad_id;

    @Column(unique = true)
    @NotNull
    private UUID ad_uuid;

    @NotNull
    private String accountType;

    @NotNull
    private boolean isExpired;

    @NotNull
    private boolean isBlocked;

    public Long getAd_id() {
        return ad_id;
    }

    public AccountDetails setAd_id(Long ad_id) {
        this.ad_id = ad_id;
        return this;
    }

    public UUID getAd_uuid() {
        return ad_uuid;
    }

    public AccountDetails setAd_uuid(UUID ad_uuid) {
        this.ad_uuid = ad_uuid;
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
