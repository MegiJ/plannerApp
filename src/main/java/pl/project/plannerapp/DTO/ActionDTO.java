package pl.project.plannerapp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import pl.project.plannerapp.model.User;

import java.time.Instant;
@AllArgsConstructor
public class ActionDTO {

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


    private ActionTypeDTO actionType;


}
