package pl.project.plannerapp.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.model.PersonalData;
import pl.project.plannerapp.model.ToDo;

@NoArgsConstructor(access = AccessLevel.PRIVATE)  // privste onacza ze konstruktor bedzie miec mod dost prywatny
public class ToDoConventerUtils {
    public static ToDoDTO convert (ToDo toDo) {
        return ToDoDTO.builder()
                .id(toDo.getId())
                .note(toDo.getNote())
                .date(toDo.getDate())
                .isCompleted(toDo.isCompleted())
                .personalDataDTO(PersonalDataConventerUtils.convert(toDo.getPersonalData()))
                .build();
    }

    public static ToDo convert (ToDoDTO toDoDTO) {
        return ToDo.builder()
                .withId(toDoDTO.getId())
                .withNote(toDoDTO.getNote())
                .withDate(toDoDTO.getDate())
                .withPersonalData(PersonalDataConventerUtils.convert(toDoDTO.getPersonalDataDTO()))
                .build();
    }
}
