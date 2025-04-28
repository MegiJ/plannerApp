package pl.project.plannerapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PersonalData {
    private long personalDataId;
    private String firstname;
    private String surname;
    private int phone;
    private String email;
    private long loggingDataId; //nie moze tu byc typ Loggin Data bo przekazesz wszystkie dane (HASLA)
}
