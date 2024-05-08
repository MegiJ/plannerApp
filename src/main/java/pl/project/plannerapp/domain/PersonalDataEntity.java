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
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private int phone;

    @Column(name = "EMAIL")
    private String email;

}
