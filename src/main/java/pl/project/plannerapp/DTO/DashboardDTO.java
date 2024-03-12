package pl.project.plannerapp.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import pl.project.plannerapp.model.User;

import java.util.List;

@AllArgsConstructor
public class DashboardDTO {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private List<ActionDTO> actions;

    private User user;
}
