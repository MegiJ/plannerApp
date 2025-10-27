package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
public class Training {
    private long id;
    private Instant date;
    private String exercise;
    private long loggingDataId;
}
