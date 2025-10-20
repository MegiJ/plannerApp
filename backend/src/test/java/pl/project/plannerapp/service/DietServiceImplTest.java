package pl.project.plannerapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DietServiceImplTest {
    private DietService dietService;

    @Mock
    private DietRepo dietRepo;
    @Mock
    private LoggingDataRepo loggingDataRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dietService = new DietServiceImpl(dietRepo, loggingDataRepo);
    }

    Instant dietDate = Instant.now();

    @Test
    public void shouldReturnAllDiets() {
        //given
        LoggingDataEntity loggingDataEntity = LoggingDataEntity.builder()
                .id(1L)
                .build();

        DietEntity dietEntityTest1 = DietEntity.builder()
                .id(1L)
                .date(dietDate)
                .meal("owsianka")
                .loggingDataEntity(loggingDataEntity)
                .build();

        DietEntity dietEntityTest2 = DietEntity.builder()
                .id(2L)
                .date(dietDate)
                .meal("jabłko")
                .loggingDataEntity(loggingDataEntity)
                .build();

        List<DietEntity> resultOfList = new ArrayList<>();
        resultOfList.add(dietEntityTest1);
        resultOfList.add(dietEntityTest2);

        when(dietRepo.findAll()).thenReturn(resultOfList);

        //when
        List<Diet> result = dietService.getAllDiet();

        //then
        Assertions.assertNotNull(result, "Lista nie powinna być null");
        Assertions.assertEquals(2, result.size(), "Lista powinna zawierać 2 elementy.");

        assertDietToReturnAll(loggingDataEntity, dietDate, result.get(0), 1L, "owsianka");
        assertDietToReturnAll(loggingDataEntity, dietDate, result.get(1), 2L, "jabłko");
    }

    @Test
    public void shouldAddDiet() {
        //given
        Diet dietToBeAdded = Diet.builder()
                .date(Instant.now())
                .meal("pomidorowa")
                .loggingDataId(1)
                .build();

        LoggingDataEntity loggingDataEntity = LoggingDataEntity.builder()
                .id(1L)
                .build();

        DietEntity dietEntityTest1 = DietEntity.builder()
                .id(1L)
                .date(Instant.now())
                .meal("pomidrowa")
                .loggingDataEntity(loggingDataEntity)
                .build();

        DietEntity dietEntityTest2 = DietEntity.builder()
                .id(2L)
                .date(Instant.now())
                .meal("sushi")
                .loggingDataEntity(loggingDataEntity)
                .build();

        when(loggingDataRepo.findById(any())).thenReturn(Optional.of(loggingDataEntity));
        when(dietRepo.save(any())).thenReturn(dietEntityTest1);
        //when
        Diet result = dietService.addDiet(dietToBeAdded);

        //then
        Assertions.assertNotNull(result.getDietId()); // sprawdzi czy dla diety zostalo nadane id
    }

    @Test
    public void shouldReturnDietById() {
        //given
        LoggingDataEntity loggingDataEntity = LoggingDataEntity.builder()
                .id(1L)
                .build();

        DietEntity dietEntity = DietEntity.builder()
                .id(1L)
                .date(dietDate)
                .meal("Owsianka")
                .loggingDataEntity(loggingDataEntity)
                .build();

        Diet diet = Diet.builder()
                .dietId(1)
                .date(dietDate)
                .meal("owsianka")
                .loggingDataId(1L)
                .build();

        when(dietRepo.findById(diet.getDietId())).thenReturn(Optional.of(dietEntity));

        //when
        Optional<Diet> result = dietService.getById(diet.getDietId());
        //then
        Assertions.assertTrue(result.isPresent()); // sprawdzi tak/nie czy zwrocil diete szukajac po id
    }

    @Test
    public void shouldDeleteDiet() {
        //given
        long dietIdToBeRemoved = 1L;

        DietEntity dietEntity = DietEntity.builder()
                .build();

        when(dietRepo.findById(dietIdToBeRemoved)).thenReturn(Optional.of(dietEntity));

        //when
        dietService.deleteDiet(dietIdToBeRemoved);
        //then
        verify(dietRepo).delete(dietEntity); //tu sprawdze tylko czy sie wywolala metoda, bo jest void i niczwego nei zwraca
    }

    @Test
    public void shouldBeModifyDiet() {
        //given
        LoggingDataEntity loggingDataEntity = LoggingDataEntity.builder()
                .id(1L)
                .build();

        long dietId = 1L;
        String newDiet = "zupa";

        DietEntity dietEntity = DietEntity.builder()
                .build();

        DietEntity updated = DietEntity.builder()
                .id(dietId)
                .date(dietDate)
                .meal(newDiet)
                .loggingDataEntity(loggingDataEntity)
                .build();

        when(dietRepo.findById(dietId)).thenReturn(Optional.of(dietEntity));
        when(dietRepo.save(dietEntity)).thenReturn(updated);

        //when
        Diet result = dietService.modifyDiet(dietId, newDiet);
        //then
        Assertions.assertEquals(newDiet, result.getMeal());
    }

    private static void assertDietToReturnAll(LoggingDataEntity loggingDataEntity, Instant dietDate, Diet result, long expectedDietId, String expectedMeal) {
        Diet actualDiet = result;

        Assertions.assertNotNull(actualDiet);
        Assertions.assertEquals(expectedDietId, actualDiet.getDietId());

        Assertions.assertNotNull(actualDiet.getMeal());
        Assertions.assertEquals(expectedMeal, actualDiet.getMeal());

        Assertions.assertNotNull(actualDiet.getLoggingDataId());
        Assertions.assertEquals(loggingDataEntity.getId(), actualDiet.getLoggingDataId());

        Assertions.assertNotNull(actualDiet.getDate());
        Assertions.assertEquals(dietDate, actualDiet.getDate());


    }
}
