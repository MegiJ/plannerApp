package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personal_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class PersonalDataEntity {

    @Id
    @SequenceGenerator(name = "personal_data_seq", sequenceName = "personal_data_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_data_seq")
    @Column(name = "pd_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private int phone;

    @Column(name = "email")
    private String email;

}
