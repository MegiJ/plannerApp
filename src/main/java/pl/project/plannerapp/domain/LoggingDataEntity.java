package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.model.PersonalData;

@Entity
@Table(name = "logging_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class LoggingDataEntity {

    @Id
    @SequenceGenerator(name = "logging_data_seq", sequenceName = "logging_data_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logging_data_seq")
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "personal_data_id")
    private PersonalData personalData;

    @Column(name = "account_details_id")
    private AccountDetails accountDetails;
}
