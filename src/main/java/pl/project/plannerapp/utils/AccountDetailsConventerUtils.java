package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.model.AccountDetails;

public class AccountDetailsConventerUtils {

    public static AccountDetailsDTO convert(AccountDetails accountDetails) {
        return new AccountDetailsDTOBuilder()
                .withId(accountDetails.getId())
                .build();
    }

    public static AccountDetails convert(AccountDetailsDTO accountDetailsDTO) {
        return new AccountDetailsBuilder()
                .withRole(accountDetailsDTO.getRole())
                .withExpired(accountDetailsDTO.isExpired())
                .withLocked(accountDetailsDTO.isLocked())
                .withCredentialsExpired(accountDetailsDTO.isCredentialsExpired())
                .withDisabled(accountDetailsDTO.isIdDisabled())
                .build();
    }
}
