package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "TRAINING")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class TrainingEntity {

    @Id
    @SequenceGenerator(name = "TRAINING_ID_SEQ", sequenceName = "TRAINING_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINING_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_TRAINING")
    private Instant date;

    @Column(name = "EXERCISE")
    private String exercise;

//    @ManyToOne
//    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
//    private PersonalDataEntity personalDataEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOGGING_DATA_ID", referencedColumnName = "ID")
    private LoggingDataEntity loggingDataEntity;

}
