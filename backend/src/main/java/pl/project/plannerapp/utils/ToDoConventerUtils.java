package pl.project.plannerapp.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.domain.ToDoEntity;
import pl.project.plannerapp.model.ToDo;

@NoArgsConstructor(access = AccessLevel.PRIVATE)  // private oznacza ze konstruktor bedzie miec mod dost prywatny
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
                .id(toDoDTO.getId())
                .note(toDoDTO.getNote())
                .date(toDoDTO.getDate())
                .personalData(PersonalDataConventerUtils.convert(toDoDTO.getPersonalDataDTO()))
                .build();
    }
    public static ToDo convert (ToDoEntity toDoEntity) {
        return ToDo.builder()
                .id(toDoEntity.getId())
                .note(toDoEntity.getNote())
                .date(toDoEntity.getDate())
                .personalData(PersonalDataConventerUtils.convert(toDoEntity.getPersonalDataEntity()))
                .build();
    }
    public static ToDoEntity convert (ToDo toDo) {
        return ToDoEntity.builder()
                .id(toDo.getId())
                .note(toDo.getNote())
                .date(toDo.getDate())
                .personalDataEntity(PersonalDataConventerUtils.convert(toDo.getPersonalData()))
                .build();
    }
}
