package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

@Entity
@Table(name = "diet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class DietEntity {

    @Id
    @SequenceGenerator(name = "diet_seq", sequenceName = "diet_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diet_seq")
    @Column(name = "d_id")
    private int id;

    @Column(name = "date")
    private Instant date;

    @Column(name = "meal")
    private String meal;

    @Column(name = "personalData_id")
    private PersonalData personalData;
}
