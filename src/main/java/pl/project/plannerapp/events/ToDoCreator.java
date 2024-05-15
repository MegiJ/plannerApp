package pl.project.plannerapp.events;

import org.springframework.context.ApplicationEvent;
import pl.project.plannerapp.DTO.LoggingDataDTO;


public class ToDoCreator extends ApplicationEvent {
    private final LoggingDataDTO loggingDataDTO;

    public ToDoCreator(Object source, LoggingDataDTO loggingDataDTO) {
        super(source);
        this.loggingDataDTO = loggingDataDTO;
    }

    public LoggingDataDTO getLoggingDataDTO() {
        return loggingDataDTO;
    }
}
