package pl.project.plannerapp.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggingDataDTO {
    private String login;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, name = "password", description = "password for user", pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$)")
    private String password;
}
