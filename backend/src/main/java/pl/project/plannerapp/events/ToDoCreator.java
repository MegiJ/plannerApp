package pl.project.plannerapp.events;

import org.springframework.context.ApplicationEvent;
import pl.project.plannerapp.DTO.PersonalDataDTO;


public class ToDoCreator extends ApplicationEvent {
    private final PersonalDataDTO personalDataDTO;

    public ToDoCreator(Object source, PersonalDataDTO personalDataDTO) {
        super(source);
        this.personalDataDTO = personalDataDTO;
    }

    public PersonalDataDTO getPersonalDataDTO() {
        return personalDataDTO;
    }
}
