package pl.project.plannerapp.DTO;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public enum ActionTypeDTO {
    CALENDAR, OBLIGATION, DIET, TRAINING, SHOPPING_LIST;
}
