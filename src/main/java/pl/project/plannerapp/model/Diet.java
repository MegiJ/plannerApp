package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;
import java.time.Instant;

@Builder
@Getter
public class Diet {

    private Long id;
    private Instant date;
    private String meal;
    private PersonalData personalData;

}
