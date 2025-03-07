package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.ToDoDTORequest;
import pl.project.plannerapp.DTO.ToDoDTOResponse;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.ToDoEntity;
import pl.project.plannerapp.model.ToDo;

public class ToDoConventerUtils {
    public static ToDoDTOResponse convert(ToDo toDo) {
        return ToDoDTOResponse.builder()
                .id(toDo.getId())
                .date(toDo.getDate())
                .note(toDo.getNote())
                .isCompleted(toDo.isCompleted())
                .loggingDataId(toDo.getLoggingDataId())
                .build();
    }

    public static ToDo convert(ToDoDTOResponse toDoDTOResponse) {
        return ToDo.builder()
                .id(toDoDTOResponse.getId())
                .date(toDoDTOResponse.getDate())
                .note(toDoDTOResponse.getNote())
                .isCompleted(toDoDTOResponse.isCompleted())
                .loggingDataId(toDoDTOResponse.getLoggingDataId())
                .build();
    }

    public static ToDo convert(ToDoDTORequest toDoDTORequest) {
        return ToDo.builder()
                .date(toDoDTORequest.getDate())
                .note(toDoDTORequest.getNote())
                .isCompleted(toDoDTORequest.isCompleted())
                .loggingDataId(toDoDTORequest.getLoggingDataId())
                .build();
    }

    public static ToDoEntity convertToEntity(ToDo toDoToEntity, LoggingDataEntity loggingDataEntity) {
        return ToDoEntity.builder()
                .date(toDoToEntity.getDate())
                .note(toDoToEntity.getNote())
                .isCompleted(toDoToEntity.isCompleted())
                .loggingDataEntity(loggingDataEntity)
                .build();
    }

    public static ToDo convert(ToDoEntity toDoEntity) {
        return ToDo.builder()
                .id(toDoEntity.getId())
                .date(toDoEntity.getDate())
                .note(toDoEntity.getNote())
                .isCompleted(toDoEntity.isCompleted())
                .loggingDataId(toDoEntity.getLoggingDataEntity().getId())
                .build();
    }
}
