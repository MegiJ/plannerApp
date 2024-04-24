package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.spi.PersistenceContext;
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
    @Column(name = "t_id")
    private int id;

    @Column(name = "date")
    private Instant date;

    @Column(name = "exercise")
    private String exercise;

    @Column(name = "personal_data_id")
    private PersonalData personalData;

}
