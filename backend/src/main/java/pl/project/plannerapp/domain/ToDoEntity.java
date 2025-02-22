package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "TODO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ToDoEntity {
    @Id
    @SequenceGenerator(name = "TODO_ID_SEQ", sequenceName = "TODO_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TODO_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_TODO")
    private Instant date;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "IS_COMPLETED")
    private boolean isCompleted;

//    @ManyToOne
//    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
//    private PersonalDataEntity personalDataEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOGGING_DATA_ID", referencedColumnName = "ID")
    private LoggingDataEntity loggingDataEntity;

}
