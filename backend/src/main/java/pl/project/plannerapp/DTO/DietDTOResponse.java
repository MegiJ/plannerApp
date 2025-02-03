package pl.project.plannerapp.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DietDTOResponse {
    @Schema(requiredMode = REQUIRED, name = "id", description = "id of diet")
    private Long id;
    @Schema(requiredMode = REQUIRED, name = "date", description = "date for diet, for example: 2024-08-07T20:00:00")
    private Instant date;
    @Schema(requiredMode = REQUIRED, name = "meal", description = "meal in diet")
    private String meal;
    @Schema(requiredMode = REQUIRED, name = "personalDataDTO", description = "personal's data who have diet")
    private PersonalDataDTO personalDataDTO;
}
