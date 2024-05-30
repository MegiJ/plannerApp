package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;
import pl.project.plannerapp.model.PersonalData;

import java.time.Instant;

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ToDoEntity {

    @Id
    @SequenceGenerator(name = "todo_seq", sequenceName = "todo_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "toto_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_TODO")
    private Instant date;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "USER_ID")
    private PersonalData personalData;

}
