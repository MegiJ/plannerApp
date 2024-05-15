package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.model.PersonalData;

public class PersonalDataConventerUtils {
    public static PersonalDataDTO convert(PersonalData personalData) {
        return new PersonalDataDTOBuilder()
                .withId(personalData.getId())
                .withFirstname(personalData.getFirstname())
                .withPhone(personalData.getPhone())
                .withEmail(personalData.getEmail())
                .build();
    }

    public static PersonalData convert(PersonalDataDTO personalDataDTO) {
        return new PersonalDataBuilder()
                .withFirstname(personalDataDTO.getFirstname())
                .withSurname(personalDataDTO.getSurname())
                .withPhone(personalDataDTO.getPhone())
                .withEmail(personalDataDTO.getEmail())
                .build();
    }
}
