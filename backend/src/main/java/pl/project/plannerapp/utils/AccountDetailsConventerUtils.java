package pl.project.plannerapp.utils;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.project.plannerapp.DTO.AccountDetailsDTO;

import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.domain.PersonalDataEntity;
import pl.project.plannerapp.model.AccountDetails;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDetailsConventerUtils {
    public static AccountDetailsDTO convert(AccountDetails accountDetails) {
        return AccountDetailsDTO.builder()
                .id(accountDetails.getId())
                .role(accountDetails.getRole())
                .isExpired(accountDetails.isExpired())
                .isLocked(accountDetails.isLocked())
                .isCredentialsExpired(accountDetails.isCredentialsExpired())
                .isDisabled(accountDetails.isDisabled())
                .build();
    }
    public static AccountDetails convert(AccountDetailsDTO accountDetailsDTO) {
        return AccountDetails.builder()
                .id(accountDetailsDTO.getId())
                .role(accountDetailsDTO.getRole())
                .isExpired(accountDetailsDTO.isExpired())
                .isLocked(accountDetailsDTO.isLocked())
                .isCredentialsExpired(accountDetailsDTO.isCredentialsExpired())
                .isDisabled(accountDetailsDTO.isDisabled())
                .build();
    }

    public static AccountDetailsEntity convertToEntity(AccountDetails accountDetails) {
        return AccountDetailsEntity.builder()
                .id(accountDetails.getId())
                .role(accountDetails.getRole())
                .isExpired(accountDetails.isExpired())
                .isLocked(accountDetails.isLocked())
                .isCredentialsExpired(accountDetails.isCredentialsExpired())
                .isDisabled(accountDetails.isDisabled())
                .build();
    }

    public static AccountDetails convert(AccountDetailsEntity accountDetailsEntity) {
        return AccountDetails.builder()
                .id(accountDetailsEntity.getId())
                .role(accountDetailsEntity.getRole())
                .isExpired(accountDetailsEntity.isExpired())
                .isLocked(accountDetailsEntity.isLocked())
                .isCredentialsExpired(accountDetailsEntity.isCredentialsExpired())
                .isDisabled(accountDetailsEntity.isDisabled())
                .build();
    }
}
