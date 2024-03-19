package pl.project.plannerapp.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.project.plannerapp.model.User;

import java.util.List;
@GeneratePojoBuilder

public class DashboardDTO {

    @NotNull
    private List<ActionDTO> actions;

    private User user;
}
