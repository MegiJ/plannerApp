package pl.project.plannerapp.model;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public enum ActionType {
    CALENDAR, OBLIGATION, DIET, TRAINING, SHOPPING_LIST;
}
