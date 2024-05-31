package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.model.Diet;


public class DietConventerUtils {
    public static DietDTO convert (Diet diet) {
        return DietDTO.builder()
                .id(diet.getId())
                .date(diet.getDate())
                .meal(diet.getMeal())
                .personalDataDTO(PersonalDataConventerUtils.convert(diet.getPersonalData()))
                .build();
    }
    public static Diet convert (DietDTO dietDTO) {
        return Diet.builder()
                .id(dietDTO.getId())
                .date(dietDTO.getDate())
                .meal(dietDTO.getMeal())
                .personalData(PersonalDataConventerUtils.convert(dietDTO.getPersonalDataDTO()))
                .build();
    }
}
