package pl.project.plannerapp.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggingDataDTO {
    private String login;
    private String password;
}
