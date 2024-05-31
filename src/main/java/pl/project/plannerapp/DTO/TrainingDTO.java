package pl.project.plannerapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.project.plannerapp.model.PersonalData;

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
