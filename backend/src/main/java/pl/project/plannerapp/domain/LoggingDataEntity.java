package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "LOGGING_DATA")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoggingDataEntity {
    @Id
    @SequenceGenerator(name = "LOGGING_DATA_ID_SEQ", sequenceName = "LOGGING_DATA_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGGING_DATA_ID_SEQ")
    @Column(name = "ID")
    private long id;

    @Column(name = "LOGIN", unique = true)
    @Size(min = 5)
    private String login;

    @Column(name = "PASSWORD")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_DETAILS_ID", referencedColumnName = "ID")
    private AccountDetailsEntity accountDetailsEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoggingDataEntity that = (LoggingDataEntity) o;
        return id == that.id && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(accountDetailsEntity, that.accountDetailsEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, accountDetailsEntity);
    }
}
