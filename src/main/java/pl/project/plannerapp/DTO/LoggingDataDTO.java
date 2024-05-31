package pl.project.plannerapp.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggingDataDTO {
    private Long id;
    private String login;
    private String password;
    private PersonalDataDTO personalDataDTO;
    private AccountDetailsDTO accountDetailsDTO;
}
