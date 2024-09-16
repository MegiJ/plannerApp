package pl.project.plannerapp.testexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathExercisesTest {
    private final MathExercises mathExercises = new MathExercises();
    @Test
    public void shouldReturnTrue () {
        //given

        //when
        boolean actual = mathExercises.isDivisibleBy2(5);

        //then
        Assertions.assertTrue(actual);
       // Assertions.assertEquals(true, actual);
    }

}