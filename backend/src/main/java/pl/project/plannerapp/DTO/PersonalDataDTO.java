package pl.project.plannerapp.DTO;

import com.google.common.base.Joiner;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDataDTO {
    private Long id;
    private String firstname;
    private String surname;
    private int phone;
    private String email;

    public String nameAndSurname() {
        return Joiner.on(" ").skipNulls().join(firstname, surname);
    }
}
