package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

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
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN", unique = true)
    @Size(min = 5)
    private String login;

    @Column(name = "PASSWORD")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private PersonalDataEntity personalDataEntity;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_DETAILS_ID", referencedColumnName = "ID")
    private AccountDetailsEntity accountDetailsEntity;

}
