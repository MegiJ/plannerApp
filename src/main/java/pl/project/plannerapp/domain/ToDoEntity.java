package pl.project.plannerapp.domain;

import jakarta.persistence.*;
import lombok.*;
import pl.project.plannerapp.repo.model.PersonalData;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "toto_seq")
    @Column(name = "ID")
    private int id;

    @Column(name = "DATE_TODO")
    private Instant date;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "USER_ID")
    private PersonalData personalData;

}
