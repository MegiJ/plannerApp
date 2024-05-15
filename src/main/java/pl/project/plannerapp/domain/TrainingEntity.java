package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

@Entity
@Table(name = "training")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class TrainingEntity {

    @Id
    @SequenceGenerator(name = "training_seq", sequenceName = "training_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_seq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_TRAINING")
    private Instant date;

    @Column(name = "EXERCISE")
    private String exercise;

    @Column(name = "USER_ID")
    private PersonalData personalData;

}
