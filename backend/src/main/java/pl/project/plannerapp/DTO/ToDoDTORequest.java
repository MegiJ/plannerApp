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
public class ToDoDTORequest {
    @Schema(requiredMode = REQUIRED, name = "date", description = "date of task, for example: 2024-08-07T20:00:00")
    private Instant date;
    @Schema(requiredMode = REQUIRED, name = "note", description = "single task of todo")
    private String note;
    @Schema(requiredMode = REQUIRED, name = "isCompleted", description = "status of task")
    private boolean isCompleted;
    @Schema(requiredMode = REQUIRED, name = "loggingDataId", description = "todo's owner logging id")
    private long loggingDataId;
}
