package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "personal_data")
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
    private Long id;

    @Column(name = "NAME")
    private String firstname;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private int phone;

    @Column(name = "EMAIL")
    private String email;

//    @OneToMany(mappedBy = "personalDataEntity", cascade = CascadeType.MERGE)
//    private List<ToDoEntity> toDoList;
//
//    @OneToMany(mappedBy = "personalDataEntity", cascade = CascadeType.MERGE)
//    private List<DietEntity> dietEntities;
//
//    @OneToMany(mappedBy = "personalDataEntity", cascade = CascadeType.MERGE)
//    private List<TrainingEntity> trainingEntities;
//
//    @OneToOne(mappedBy = "personalDataEntity", cascade = CascadeType.MERGE)
//    private LoggingDataEntity loggingDataEntities;

}
