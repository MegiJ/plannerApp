package pl.project.plannerapp.testexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CampOrganisationTest {

    private CampOrganisation campOrganisation = new CampOrganisation(new ArrayList<>());

    @Test
    public void shouldTransformName() {
        //given - dane wejściowe
        String lastname = "Jot";
        String firstname = "Magda";

        //when - to co chcemy przetestowac
        String result = campOrganisation.transformName(firstname, lastname);

        //then - wynik
        Assertions.assertEquals("Magda Jot", result);
    }

    @Test
    public void shouldGetStudent() {
        //given
        String name = "magda";

        //when
        String result = campOrganisation.getStudent(name);

        //then
        Assertions.assertEquals("", result);
    }

    @Test
    public void shouldExist() {
        //goven
        List<String> studentList = Arrays.asList("Magda Jot", "Daniel Gie", "Gabrysia Gie");

        //when
        String result = campOrganisation.getStudent("Daniel Gie");
        //then
        Assertions.assertEquals("", result);
    }

}