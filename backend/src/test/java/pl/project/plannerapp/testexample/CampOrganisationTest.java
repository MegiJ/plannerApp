package pl.project.plannerapp.testexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CampOrganisationTest {

    private List<String> students;

    //private CampOrganisation campOrganisation = new CampOrganisation(new ArrayList<>());
    private CampOrganisation campOrganisation;

    @BeforeAll
    public void setUp() {
        students = new ArrayList<>();
        students.add("Magd Jot");
        students.add("Daniel Gie");
        students.add("Gabrysia Gie");
        campOrganisation = new CampOrganisation(students);
    }

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
        //given
        // to jest w BeforeAll
        //when
        String result = campOrganisation.getStudent("Daniel Gie");
        //then
        Assertions.assertEquals("Daniel Gie", result);
    }

    @Test
    public void shouldStudentBeAdded() {
        //given
        // to jest w BeforeAll
        //when
        boolean result = campOrganisation.addStudent("Ania", "Prog");

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldStudentNotBeAdded() {
        //given

        //when
        boolean result = campOrganisation.addStudent("Daniel", "Gie");

        //then
        Assertions.assertFalse(result);
    }

}