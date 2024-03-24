package pl.project.plannerapp.DTO;
import jakarta.validation.constraints.NotNull;

public class ToDoDTO {

    @NotNull
    private String note;
}
