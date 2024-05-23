package pl.project.plannerapp.utils;


import lombok.Builder;
import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.model.Diet;

@Builder
public class DietConventerUtils {


    public static DietDTO convert (Diet diet) {
        return new DietDTOBuilder()
                .withId(diet.getId())
                .withDate(diet.getDate())
                .withMeal(diet.getMeal())
                .withPersonalData(convert(diet.getPersonalData()))
                .build();
    }

    public static Diet convert (DietDTO dietDTO) {
        return new DietBuilder()
                .withId(dietDTO.getId())
                .withDate(dietDTO.getDate())
                .withMeal(dietDTO.getMeal())
                .withPersonalData(convert(dietDTO.getPersonalData()))
                .build();
    }
}
