package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoggingData {
    private long id;
    private String login;
    private String password;
    private AccountDetails accountDetails;
}
