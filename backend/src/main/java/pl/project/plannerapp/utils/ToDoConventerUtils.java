package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.ToDoDTO;
import pl.project.plannerapp.domain.ToDoEntity;
import pl.project.plannerapp.model.ToDo;

public class ToDoConventerUtils {
    public static ToDoDTO convert (ToDo toDo) {
        return ToDoDTO.builder()
                .id(toDo.getId())
                .note(toDo.getNote())
                .date(toDo.getDate())
                .isCompleted(toDo.isCompleted())
                .loggingDataDTO(LoggingDataConventerUtils.convert(toDo.getLoggingData()))
                .build();
    }

    public static ToDo convert(ToDoDTO toDoDTO) {
        return ToDo.builder()
                .id(toDoDTO.getId())
                .note(toDoDTO.getNote())
                .date(toDoDTO.getDate())
                .loggingData(LoggingDataConventerUtils.convert(toDoDTO.getLoggingDataDTO()))
                .build();
    }

    public static ToDoEntity convertToEntity(ToDo toToEntity) {
        return ToDoEntity.builder()
                .note(toToEntity.getNote())
                .date(toToEntity.getDate())
                .loggingDataEntity(LoggingDataConventerUtils.convertToEntity(toToEntity.getLoggingData()))
                .build();
    }

    public static ToDo convert(ToDoEntity toDoEntity) {
        return ToDo.builder()
                .note(toDoEntity.getNote())
                .date(toDoEntity.getDate())
                .loggingData(LoggingDataConventerUtils.convert(toDoEntity.getLoggingDataEntity()))
                .build();
    }
}
