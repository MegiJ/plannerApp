package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder(setterPrefix = "with")
@Getter
public class ToDo {
    private Long id;
    private String note;
    private Instant date;
    private boolean isCompleted;
    private PersonalData personalData;
}
