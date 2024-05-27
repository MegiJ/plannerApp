package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.model.ToDo;


public class ToDoConventerUtils {
    public static ToDoDTO convert (ToDo toDo) {
        return new ToDoDTOBuilder()
                .withId(toDo.getId())
                .withNote(toDo.getNote())
                .withDate(toDo.getDate())
                .withPersonalData(convert(toDo.getPersonalData()))
                .build();
    }

    public static ToDo convert (ToDoDTO toDoDTO) {
        return new ToDoDTOBuilder()
                .withId(toDoDTO.getId())
                .withNote(toDoDTO.getNote())
                .withDate(toDoDTO.getDate())
                .withPersonalData(convert(toDoDTO.getPersonalData()))
                .build();
    }
}
