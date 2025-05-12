package pl.project.plannerapp.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggingDataDTOResponse {
    @Schema(requiredMode = REQUIRED, name = "login", description = "login for user")
    private String login;
    @Schema(requiredMode = REQUIRED, name = "password", description = "password for user",
            pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$)")
    private String password;
    @Schema(requiredMode = REQUIRED, name = "accountDetailsId", description = "logging data's ovner account details id")
    private long accountDetailsId;
}
