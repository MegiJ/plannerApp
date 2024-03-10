package pl.project.plannerapp.model;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

public class Period {

    @Nullable
    private LocalDateTime begin;

    @Nullable
    private LocalDateTime end;

    @Nullable
    public LocalDateTime getBegin() {
        return begin;
    }

    public Period setBegin(@Nullable LocalDateTime begin) {
        this.begin = begin;
        return this;
    }

    @Nullable
    public LocalDateTime getEnd() {
        return end;
    }

    public Period setEnd(@Nullable LocalDateTime end) {
        this.end = end;
        return this;
    }
}
