package pl.project.plannerapp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import pl.project.plannerapp.model.LogginData;
import pl.project.plannerapp.model.PersonalData;

public class UserDTO {

    @NotNull
    private PersonalDataDTO personalDataDTO;

    @NotNull
    private LogginDataDTO logginDataDTO;

    public PersonalDataDTO getPersonalDataDTO() {
        return personalDataDTO;
    }

    public UserDTO setPersonalDataDTO(PersonalDataDTO personalDataDTO) {
        this.personalDataDTO = personalDataDTO;
        return this;
    }

    public LogginDataDTO getLogginDataDTO() {
        return logginDataDTO;
    }

    public UserDTO setLogginDataDTO(LogginDataDTO logginDataDTO) {
        this.logginDataDTO = logginDataDTO;
        return this;
    }
}
