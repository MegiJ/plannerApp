package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.domain.PersonalDataEntity;
import pl.project.plannerapp.model.PersonalData;


public class PersonalDataConventerUtils {
    public static PersonalDataDTO convert(PersonalData personalData) {
        return PersonalDataDTO.builder()
                .withId(personalData.getId())
                .withFirstname(personalData.getFirstname())
                .withSurname(personalData.getSurname())
                .withPhone(personalData.getPhone())
                .withEmail(personalData.getEmail())
                .build();
    }
    public static PersonalData convert(PersonalDataDTO personalDataDTO) {
        return PersonalData.builder()
                .withId(personalDataDTO.getId())
                .withFirstname(personalDataDTO.getFirstname())
                .withSurname(personalDataDTO.getSurname())
                .withPhone(personalDataDTO.getPhone())
                .withEmail(personalDataDTO.getEmail())
                .build();
    }
    public static PersonalData convert (PersonalDataEntity personalDataEntity) {
        return PersonalData.builder()
                .withId(personalDataEntity.getId())
                .withFirstname(personalDataEntity.getFirstname())
                .withPhone(personalDataEntity.getPhone())
                .withEmail(personalDataEntity.getEmail())
                .build();
    }
    public static PersonalDataEntity convert (PersonalData personalData) {
        return PersonalDataEntity.builder()
                .id(personalData.getId())
                .firstname(personalData.getFirstname())
                .surname(personalData.getSurname())
                .phone(personalData.getPhone())
                .email(personalData.getEmail())
                .build();
    }

}
