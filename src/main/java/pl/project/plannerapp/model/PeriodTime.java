package pl.project.plannerapp.model;

import lombok.Builder;
import pl.project.plannerapp.validator.PeriodConstraint;
import javax.annotation.Nullable;
import java.time.LocalTime;

@PeriodConstraint

public class PeriodTime {

    @Nullable
    private LocalTime begin;

    @Nullable
    private LocalTime end;

    @Nullable
    public LocalTime getBegin() {
        return begin;
    }

    public PeriodTime setBegin(@Nullable LocalTime begin) {
        this.begin = begin;
        return this;
    }

    @Nullable
    public LocalTime getEnd() {
        return end;
    }

    public PeriodTime setEnd(@Nullable LocalTime end) {
        this.end = end;
        return this;
    }
}
