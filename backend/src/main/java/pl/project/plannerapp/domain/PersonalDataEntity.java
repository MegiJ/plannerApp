package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "PERSONAL_DATA")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonalDataEntity {
    @Id
    @SequenceGenerator(name = "PERSONAL_DATA_ID_SEQ", sequenceName = "PERSONAL_DATA_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONAL_DATA_ID_SEQ")
    @Column(name = "ID")
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private int phone;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOGGING_DATA_ID", referencedColumnName = "ID")
    private LoggingDataEntity loggingDataEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalDataEntity that = (PersonalDataEntity) o;
        return id == that.id && phone == that.phone && Objects.equals(firstname, that.firstname) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(loggingDataEntity, that.loggingDataEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, surname, phone, email, loggingDataEntity);
    }
}
