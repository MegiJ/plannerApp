package pl.project.plannerapp.DTO;

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
    private AccountDetailsDTO accountDetailsDTO;

}
