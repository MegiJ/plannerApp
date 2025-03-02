package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountDetailsEntity {

    @Id
    @SequenceGenerator(name = "ACCOUNT_DETAILS_ID_SEQ", sequenceName = "ACCOUNT_DETAILS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_DETAILS_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "IS_EXPIRED")
    private boolean isExpired;

    @Column(name = "IS_LOCKED")
    private boolean isLocked;

    @Column(name = "IS_CREDENTIALS_EXPIRED")
    private boolean isCredentialsExpired;

    @Column(name = "IS_DISABLED")
    private boolean isDisabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOGGING_DATA_ID", referencedColumnName = "ID")
    private LoggingDataEntity loggingDataEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDetailsEntity that = (AccountDetailsEntity) o;
        return isExpired == that.isExpired && isLocked == that.isLocked && isCredentialsExpired == that.isCredentialsExpired && isDisabled == that.isDisabled && Objects.equals(id, that.id) && Objects.equals(role, that.role) && Objects.equals(loggingDataEntity, that.loggingDataEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, isExpired, isLocked, isCredentialsExpired, isDisabled, loggingDataEntity);
    }
}
