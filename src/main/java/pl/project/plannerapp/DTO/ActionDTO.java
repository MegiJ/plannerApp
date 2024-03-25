package pl.project.plannerapp.DTO;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.project.plannerapp.model.AccountDetails;

import java.time.Instant;

@GeneratePojoBuilder
public class ActionDTO {

    @NotNull
    private Instant date;

    @NotNull
    private String note;

    @NotNull
    @Embedded
    private AccountDetails accountDetails;


    private ActionTypeDTO actionTypeDTO;

    public ActionDTO() {
    }
}
