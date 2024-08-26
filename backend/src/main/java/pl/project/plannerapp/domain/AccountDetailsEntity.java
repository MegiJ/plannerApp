package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToOne(mappedBy = "accountDetailsEntity")
    private LoggingDataEntity loggingDataEntities;
}
