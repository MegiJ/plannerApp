package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoggingData {
    private Long id;
    private String login;
    private String password;
    private PersonalData personalData;
    private AccountDetails accountDetails;
}
