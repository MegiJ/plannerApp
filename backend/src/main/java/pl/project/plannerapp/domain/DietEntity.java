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
    @SequenceGenerator(name = "DIET_ID_SEQ", sequenceName = "DIET_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIET_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_OF_DIET")
    private Instant date;

    @Column(name = "MEAL")
    private String meal;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private PersonalDataEntity personalDataEntity;
}
