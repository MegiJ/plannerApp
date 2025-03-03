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
public class DietDTORequest {
    @Schema(requiredMode = REQUIRED, name = "date", description = "date for diet, for example: 2024-08-07T20:00:00")
    private Instant date;
    @Schema(requiredMode = REQUIRED, name = "meal", description = "meal in diet")
    private String meal;
    @Schema(requiredMode = REQUIRED, name = "loggingDataId", description = "id for logging data of diet")
    private long loggingDataId;
}
