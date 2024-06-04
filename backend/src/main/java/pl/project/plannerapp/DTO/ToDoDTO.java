package pl.project.plannerapp.DTO;

import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDTO {
    private Long id;
    private String note;
    private Instant date;
    private boolean isCompleted;
    private PersonalDataDTO personalDataDTO;
}
