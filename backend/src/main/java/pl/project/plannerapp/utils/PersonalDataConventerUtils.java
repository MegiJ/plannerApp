package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.domain.PersonalDataEntity;
import pl.project.plannerapp.model.PersonalData;


public class PersonalDataConventerUtils {
    public static PersonalDataDTO convert(PersonalData personalData) {
        return PersonalDataDTO.builder()
                .id(personalData.getId())
                .firstname(personalData.getFirstname())
                .surname(personalData.getSurname())
                .phone(personalData.getPhone())
                .email(personalData.getEmail())
                .build();
    }

    public static PersonalData convert(PersonalDataDTO personalDataDTO) {
        return PersonalData.builder()
                .id(personalDataDTO.getId())
                .firstname(personalDataDTO.getFirstname())
                .surname(personalDataDTO.getSurname())
                .phone(personalDataDTO.getPhone())
                .email(personalDataDTO.getEmail())
                .build();
    }

    public static PersonalDataEntity convertToEntity(PersonalData personalDataToEntity) {
        return PersonalDataEntity.builder()
                .id(personalDataToEntity.getId())
                .firstname(personalDataToEntity.getFirstname())
                .surname(personalDataToEntity.getSurname())
                .phone(personalDataToEntity.getPhone())
                .email(personalDataToEntity.getEmail())
                .build();
    }
    public static PersonalData convert (PersonalDataEntity personalDataEntity) {
        return PersonalData.builder()
                .id(personalDataEntity.getId())
                .firstname(personalDataEntity.getFirstname())
                .surname(personalDataEntity.getSurname())
                .phone(personalDataEntity.getPhone())
                .email(personalDataEntity.getEmail())
                .build();
    }
}
