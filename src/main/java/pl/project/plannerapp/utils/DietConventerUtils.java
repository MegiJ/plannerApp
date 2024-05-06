package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.model.DietBuilder;

public class DietConventerUtils {
    public static DietDTO convert(Diet diet) {
        return new DietDTOBuilder()
                .withId(diet.getId())
                .withPersonalData(convert(diet.getPersonalData()))
                .build();
    }

    public static Diet convert(DietDTO dietDTO) {
        return new DietBuilder()
                .withDate(dietDTO.getDate())
                .withMeal(dietDTO.getMeal())
                .build();
    }

}
