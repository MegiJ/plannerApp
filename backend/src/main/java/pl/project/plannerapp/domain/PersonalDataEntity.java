package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private Long id;

    @Column(name = "NAME")
    private String firstname;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private int phone;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private AccountDetailsEntity accountDetailsEntity;

//    @OneToMany(mappedBy = "personalDataEntity", cascade = CascadeType.ALL)
//    private List<ToDoEntity> toDoList;
//
//    @OneToMany(mappedBy = "personalDataEntity", cascade = CascadeType.ALL)
//    private List<DietEntity> dietEntities;
//
//    @OneToMany(mappedBy = "personalDataEntity", cascade = CascadeType.ALL)
//    private List<TrainingEntity> trainingEntities;
//
//    @OneToOne(mappedBy = "personalDataEntity", cascade = CascadeType.ALL)
//    private LoggingDataEntity loggingDataEntities;

}
