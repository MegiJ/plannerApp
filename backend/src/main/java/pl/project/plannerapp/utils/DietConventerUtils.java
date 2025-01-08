package pl.project.plannerapp.utils;


import pl.project.plannerapp.DTO.DietDTORequest;
import pl.project.plannerapp.DTO.DietDTOResponse;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.model.PersonalData;


public class DietConventerUtils {
    public static DietDTOResponse convert(Diet diet) {
        return DietDTOResponse.builder()
                .id(diet.getId())
                .date(diet.getDate())
                .meal(diet.getMeal())
                .personalDataDTO(PersonalDataConventerUtils.convert(diet.getPersonalData()))
                .build();
    }

    public static Diet convert(DietDTOResponse dietDTOResponse) {
        return Diet.builder()
                .id(dietDTOResponse.getId())
                .date(dietDTOResponse.getDate())
                .meal(dietDTOResponse.getMeal())
                .personalData(PersonalDataConventerUtils.convert(dietDTOResponse.getPersonalDataDTO()))
                .build();
    }

    public static Diet convert(DietDTORequest dietDTORequest) {
        return Diet.builder()
                .date(dietDTORequest.getDate())
                .meal(dietDTORequest.getMeal())
                .personalData(PersonalData.builder().personalDataId(dietDTORequest.getPersonalDataId()).build())
                .build();
    }

    public static DietEntity convertToEntity(Diet dietToEntity, AccountDetailsEntity accountDetailsEntity) {
        return DietEntity.builder()
                .date(dietToEntity.getDate())
                .meal(dietToEntity.getMeal())
                .personalDataEntity(PersonalDataConventerUtils.convertToEntity(dietToEntity.getPersonalData(), accountDetailsEntity))
                .build();
    }

    public static Diet convert(DietEntity dietEntity) {
        return Diet.builder()
                .id(dietEntity.getId())
                .date(dietEntity.getDate())
                .meal(dietEntity.getMeal())
                .personalData(PersonalDataConventerUtils.convert(dietEntity.getPersonalDataEntity()))
                .build();
    }


}
