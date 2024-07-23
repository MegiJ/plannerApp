package pl.project.plannerapp.DTO;

import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    private Long id;
    private Instant date;
    private String exercise;
    private PersonalDataDTO personalDataDTO;
}
