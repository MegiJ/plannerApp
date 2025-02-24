package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
public class Training {
    private Long id;
    private Instant date;
    private String exercise;
    private LoggingData loggingData;
}
