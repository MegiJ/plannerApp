package pl.project.plannerapp.DTO;

import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class AccountDetailsDTO {

    @NotNull
    private UUID ad_uuid;

    @NotNull
    private String accountType;

    @NotNull
    private boolean isExpired;

    @NotNull
    private boolean isBlocked;

    public UUID getAd_uuid() {
        return ad_uuid;
    }

    public AccountDetailsDTO setAd_uuid(UUID ad_uuid) {
        this.ad_uuid = ad_uuid;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public AccountDetailsDTO setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public AccountDetailsDTO setExpired(boolean expired) {
        isExpired = expired;
        return this;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public AccountDetailsDTO setBlocked(boolean blocked) {
        isBlocked = blocked;
        return this;
    }
}
