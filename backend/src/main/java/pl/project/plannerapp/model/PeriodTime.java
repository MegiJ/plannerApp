package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;
import pl.project.plannerapp.validator.PeriodConstraint;
import java.time.LocalTime;

@Builder
@PeriodConstraint
@Getter
public class PeriodTime {
    private LocalTime begin;
    private LocalTime end;

}
