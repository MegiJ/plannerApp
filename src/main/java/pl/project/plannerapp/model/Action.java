package pl.project.plannerapp.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.time.Instant;

@GeneratePojoBuilder
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private Instant date;

    @NotNull
    private String note;

    @NotNull
    @Embedded
    private User user;


    private ActionType actionType;


}
