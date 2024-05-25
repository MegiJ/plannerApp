package pl.project.plannerapp.DTO;

import lombok.Builder;

import javax.annotation.Nullable;
import java.time.LocalTime;

public class PeriodTimeDTO {

    @Nullable
    private LocalTime begin;

    @Nullable
    private LocalTime end;

    @Nullable
    public LocalTime getBegin() {
        return begin;
    }

    public PeriodTimeDTO setBegin(@Nullable LocalTime begin) {
        this.begin = begin;
        return this;
    }

    @Nullable
    public LocalTime getEnd() {
        return end;
    }

    public PeriodTimeDTO setEnd(@Nullable LocalTime end) {
        this.end = end;
        return this;
    }
}
