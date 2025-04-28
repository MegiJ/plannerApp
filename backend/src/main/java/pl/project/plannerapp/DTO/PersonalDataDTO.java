package pl.project.plannerapp.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDataDTO {
    @Schema(requiredMode = REQUIRED, name = "firstname", description = "firstname of personal data")
    private String firstname;
    @Schema(requiredMode = REQUIRED, name = "surname", description = "surname of personal data")
    private String surname;
    @Schema(requiredMode = REQUIRED, name = "phone", description = "phone of personal data")
    private int phone;
    @Schema(requiredMode = REQUIRED, name = "email", description = "email of personal data")
    private String email;
    @Schema(requiredMode = REQUIRED, name = "loggingDataId", description = "personal data's owner logging id")
    private long loggingDataId;

}
