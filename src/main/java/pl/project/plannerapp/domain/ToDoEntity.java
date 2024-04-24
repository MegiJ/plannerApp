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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "toto_seq")
    @Column(name = "td_id")
    private int id;

    @Column(name = "note")
    private String note;

    @Column(name = "date")
    private Instant date;

    @Column(name = "personal_data_id")
    private PersonalData personalData;

}
