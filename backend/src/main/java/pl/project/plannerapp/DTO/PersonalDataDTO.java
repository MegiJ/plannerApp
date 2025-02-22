package pl.project.plannerapp.DTO;

import lombok.*;
import pl.project.plannerapp.model.LoggingData;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDataDTO {
    private String firstname;
    private String surname;
    private int phone;
    private String email;
    //    private Long accountDetailsId;
    private LoggingData loggingDataId;
}
