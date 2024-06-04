package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class PersonalData {
    private Long id;
    private String firstname;
    private String surname;
    private int phone;
    private String email;
}
