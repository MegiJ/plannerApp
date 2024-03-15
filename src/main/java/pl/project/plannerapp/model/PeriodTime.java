package pl.project.plannerapp.model;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.time.LocalTime;

@GeneratePojoBuilder
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
