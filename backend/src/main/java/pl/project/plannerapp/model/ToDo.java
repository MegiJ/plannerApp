package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
public class ToDo {
    private Long id;
    private Instant date;
    private String note;
    private boolean isCompleted;
    private long loggingDataId;
}
