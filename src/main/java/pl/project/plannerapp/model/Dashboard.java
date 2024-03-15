package pl.project.plannerapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.List;
@GeneratePojoBuilder
@AllArgsConstructor
public class Dashboard {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private List<Action> actions;

    private User user;
}
