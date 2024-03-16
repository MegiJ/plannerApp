package pl.project.plannerapp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.project.plannerapp.model.LogginData;
import pl.project.plannerapp.model.PersonalData;

import java.util.UUID;

@GeneratePojoBuilder
public class UserDTO {

    @NotNull
    private UUID uuid;

    @NotNull
    private String accountType;

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

    public UUID getUuid() {
        return uuid;
    }

    public UserDTO setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public UserDTO setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }
}
