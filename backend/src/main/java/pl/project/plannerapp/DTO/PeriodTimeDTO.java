package pl.project.plannerapp.DTO;

import lombok.*;

import java.time.LocalTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeriodTimeDTO {
    private LocalTime begin;
    private LocalTime end;
}
