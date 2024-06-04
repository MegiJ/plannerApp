package pl.project.plannerapp.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeriodDTO {
    private LocalDateTime begin;
    private LocalDateTime end;
}
