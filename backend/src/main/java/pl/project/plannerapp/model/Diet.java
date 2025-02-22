package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
@Getter
@Setter
public class Diet {
    private long dietId;
    private Instant date;
    private String meal;
    //    private PersonalData personalData;
    private LoggingData loggingData;

}
