package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AccountDetails {

    private long id;
    private String role;
    private boolean isExpired;
    private boolean isLocked;
    private boolean isCredentialsExpired;
    private boolean isDisabled;

}
