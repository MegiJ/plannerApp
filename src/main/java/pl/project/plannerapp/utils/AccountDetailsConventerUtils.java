package pl.project.plannerapp.utils;

import lombok.Builder;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.model.AccountDetails;

@Builder
@GeneratePojoBuilder
public class AccountDetailsConventerUtils {

    public static AccountDetailsDTO convert(AccountDetails accountDetails) {
        return new AccountDetailsDTOBuilder()
                .withId(accountDetails.getId())
                .withRole(accountDetails.getRole())
                .withExpired(accountDetails.isExpired())
                .withLocked(accountDetails.isLocked())
                .withCredentialsExpired(accountDetails.isCredentialsExpired())
                .withDisabled(accountDetails.isDisabled())
                .build();
    }

    public static AccountDetails convert(AccountDetailsDTO accountDetailsDTO) {
        return new AccountDetailsBuilder()
                .withId(accountDetailsDTO.getId())
                .withRole(accountDetailsDTO.getRole())
                .withExpired(accountDetailsDTO.isExpired())
                .withLocked(accountDetailsDTO.isLocked())
                .withCredentialsExpired(accountDetailsDTO.isCredentialsExpired())
                .withDisabled(accountDetailsDTO.isIdDisabled())
                .build();
    }
}
