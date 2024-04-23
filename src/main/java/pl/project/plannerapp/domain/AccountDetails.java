package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class AccountDetails {

    @Id
    @SequenceGenerator(name = "account_details_seq", sequenceName = "account_details_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_details_seq")
    @Column(name = "ad_id")
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "isExpired")
    private boolean isExpired;

    @Column(name = "isLocked")
    private boolean isLocked;

    @Column(name = "isCredentialExpired")
    private boolean isCredentialsExpired;

}
