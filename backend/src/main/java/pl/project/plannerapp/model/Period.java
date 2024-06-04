package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;
import pl.project.plannerapp.validator.PeriodConstraint;

import java.time.LocalDateTime;

@Builder
@PeriodConstraint
@Getter
public class Period {

    private LocalDateTime begin;
    private LocalDateTime end;

}
