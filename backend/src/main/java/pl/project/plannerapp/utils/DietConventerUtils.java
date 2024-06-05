package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.model.Diet;


public class DietConventerUtils {
    public static DietDTO convert (Diet diet) {
        return DietDTO.builder()
                .id(diet.getId())
                .date(diet.getDate())
                .meal(diet.getMeal())
                .build();
    }
    public static Diet convert (DietDTO dietDTO) {
        return Diet.builder()
                .id(dietDTO.getId())
                .date(dietDTO.getDate())
                .meal(dietDTO.getMeal())
                .build();
    }
    public static DietEntity convert (Diet dietToEntity) {
        return DietEntity.builder()
                .id((dietToEntity.getId()))
                .date(dietToEntity.getDate())
                .meal(dietToEntity.getMeal())
                .build();
    }
    public static Diet convert (DietEntity dietEntity) {
        return Diet.builder()
                .id(dietEntity.getId())
                .date(dietEntity.getDate())
                .meal(dietEntity.getMeal())
                .build();
    }
}
