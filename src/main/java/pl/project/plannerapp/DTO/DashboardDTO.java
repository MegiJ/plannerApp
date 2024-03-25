package pl.project.plannerapp.DTO;

import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.project.plannerapp.model.AccountDetails;

import java.util.List;
@GeneratePojoBuilder

public class DashboardDTO {

    @NotNull
    private List<ActionDTO> actions;

    private AccountDetails accountDetails;
}
