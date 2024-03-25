package pl.project.plannerapp.model;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public enum ActionType {
    CALENDAR, TODO, DIET, TRAINING, SHOPPING_LIST;
}
