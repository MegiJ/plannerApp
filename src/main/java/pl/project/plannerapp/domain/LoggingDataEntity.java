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
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACCOUNT_ID")
    private PersonalData personalData;

    @Column(name = "ACCOUNT_DETAILS_ID")
    private AccountDetails accountDetails;

}
