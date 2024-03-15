package pl.project.plannerapp.DTO;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
@GeneratePojoBuilder
public class PeriodDTO {

    @Nullable
    private LocalDateTime begin;

    @Nullable
    private LocalDateTime end;

    @Nullable
    public LocalDateTime getBegin() {
        return begin;
    }

    public PeriodDTO setBegin(@Nullable LocalDateTime begin) {
        this.begin = begin;
        return this;
    }

    @Nullable
    public LocalDateTime getEnd() {
        return end;
    }

    public PeriodDTO setEnd(@Nullable LocalDateTime end) {
        this.end = end;
        return this;
    }
}
