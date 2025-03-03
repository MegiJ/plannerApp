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
public class TrainingDTOResposne {
    @Schema(requiredMode = REQUIRED, name = "id", description = "id of training")
    private Long id;
    @Schema(requiredMode = REQUIRED, name = "date", description = "date for diet, for example: 2024-08-07T20:00:00")
    private Instant date;
    @Schema(requiredMode = REQUIRED, name = "exercise", description = "single exercise of training")
    private String exercise;
    @Schema(requiredMode = REQUIRED, name = "loggingDataId", description = "training's owner logging id")
    private long loggingDataId;
}
