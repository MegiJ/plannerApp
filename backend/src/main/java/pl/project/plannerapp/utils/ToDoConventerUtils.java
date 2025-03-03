package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.ToDoEntity;
import pl.project.plannerapp.model.ToDo;

public class ToDoConventerUtils {
    public static ToDoDTO convert (ToDo toDo) {
        return ToDoDTO.builder()
                .id(toDo.getId())
                .note(toDo.getNote())
                .date(toDo.getDate())
                .isCompleted(toDo.isCompleted())
                .build();
    }

    public static ToDo convert(ToDoDTO toDoDTO) {
        return ToDo.builder()
                .id(toDoDTO.getId())
                .note(toDoDTO.getNote())
                .date(toDoDTO.getDate())
                .build();
    }

    public static ToDoEntity convertToEntity(ToDo toDoToEntity, LoggingDataEntity loggingDataEntity) {
        return ToDoEntity.builder()
                .note(toDoToEntity.getNote())
                .date(toDoToEntity.getDate())
                .loggingDataEntity(loggingDataEntity)
                .build();
    }

    public static ToDo convert(ToDoEntity toDoEntity) {
        return ToDo.builder()
                .note(toDoEntity.getNote())
                .date(toDoEntity.getDate())
                .loggingDataId(toDoEntity.getLoggingDataEntity().getId())
                .build();
    }
}
