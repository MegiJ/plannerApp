package pl.project.plannerapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.TrainingEntity;
import pl.project.plannerapp.model.Training;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.TrainingRepo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TrainingServiceImplTest {
    @Mock
    private TrainingRepo trainingRepo; // jak nie chcesz zeby sprawdzalo Ci tych pol tylko sam trainig' mock to taki "oszust, zaslepka"
    @Mock
    private LoggingDataRepo loggingDataRepo;

    private TrainingService trainingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); //this bo ma byc ta klasa teraz TrainingServiceImplTest
        trainingService = new TrainingServiceImpl(trainingRepo, loggingDataRepo);
    }

    @Test
    public void shouldAddExercise() {
        //given (to co potrzebujesz zeby wykonac when)
        LoggingDataEntity loggingDataEntity = LoggingDataEntity.builder()
                .id(1L)
                .build();

        TrainingEntity trainingEntity = TrainingEntity.builder()
                .id(1L)
                .date(Instant.now())
                .exercise("koszykówka")
                .loggingDataEntity(loggingDataEntity)
                .build();

        Training trainingToBeAdded = Training.builder()
                .date(Instant.now())
                .exercise("koszykówka")
                .loggingDataId(1)
                .build();
        when(loggingDataRepo.findById(any())).thenReturn(Optional.of(loggingDataEntity));
        when(trainingRepo.save(any())).thenReturn(trainingEntity); // odpowiada savedNewExercise z TrainingServiceImpl linijka 41

        //when (co testujesz w tej metodzie/tescie, zaczynaj od tego!)
        Training result = trainingService.addExercise(trainingToBeAdded);

        //then
        Assertions.assertNotNull(result.getId());
    }

    @Test
    public void shouldReturnAllExercises() {
        //given
        LoggingDataEntity loggingDataEntity = LoggingDataEntity.builder()
                .id(1L)
                .build();

        Instant trainingDate = Instant.now();
        Training getAllTraining = Training.builder()
                .id(1L)
                .date(trainingDate)
                .exercise("koszykówka")
                .loggingDataId(1)
                .build();

        TrainingEntity trainingEntity = TrainingEntity.builder()
                .id(1L)
                .date(trainingDate)
                .exercise("koszykówka") // lub null
                .loggingDataEntity(loggingDataEntity)
                .build();

        TrainingEntity trainingEntity2 = TrainingEntity.builder()
                .id(2L)
                .date(trainingDate)
                .exercise("boks")
                .loggingDataEntity(loggingDataEntity)
                .build();


        List<TrainingEntity> resultOfList = new ArrayList<>();
        resultOfList.add(trainingEntity);
        resultOfList.add(trainingEntity2);

        when(trainingRepo.findAll()).thenReturn(resultOfList);
        //when
        List<Training> result = trainingService.getAllTraining();

        //then
        Assertions.assertNotNull(result, "Lista nie powinna być null");
        Assertions.assertEquals(2, result.size(), "Lista powinna zawierać 3 elementy");

        assertTraining(loggingDataEntity, trainingDate, result.get(0), 1L, "koszykówka"); // metoda do sprawdzania poprawnosci treningow, zeby nie powielac d boksu
        assertTraining(loggingDataEntity, trainingDate, result.get(1), 2L, "boks");

    }

    private static void assertTraining(LoggingDataEntity loggingDataEntity, Instant trainingDate, Training result,
                                       long expectedTrainingId, String expectedExercise) {
        Training actualTraining = result;

        Assertions.assertNotNull(actualTraining);
        Assertions.assertEquals(expectedTrainingId, actualTraining.getId());
        Assertions.assertNotNull(actualTraining.getExercise());
        Assertions.assertEquals(expectedExercise, actualTraining.getExercise());
        Assertions.assertNotNull(actualTraining.getLoggingDataId());
        Assertions.assertEquals(loggingDataEntity.getId(), actualTraining.getLoggingDataId());
        Assertions.assertNotNull(actualTraining.getDate());
        Assertions.assertEquals(trainingDate, actualTraining.getDate());
    }

}