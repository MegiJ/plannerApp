package pl.project.plannerapp.DTO;

import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DietDTO {
    private Long id;
    private Instant date;
    private String meal;
    private PersonalDataDTO personalDataDTO;
}
