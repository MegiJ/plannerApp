package pl.project.plannerapp.DTO;

import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DietDTORequest {
    private Instant date;
    private String meal;
    private int personalDataId;
}
