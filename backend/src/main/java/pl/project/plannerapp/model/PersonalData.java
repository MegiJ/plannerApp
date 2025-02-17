package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PersonalData {
    private long personalDataId;
    private String firstname;
    private String surname;
    private int phone;
    private String email;
    private Long accountDetailsId;
}
