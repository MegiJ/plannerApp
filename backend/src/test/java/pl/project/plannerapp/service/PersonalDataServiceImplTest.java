package pl.project.plannerapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.PersonalDataEntity;
import pl.project.plannerapp.model.PersonalData;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonalDataServiceImplTest {

    private PersonalDataService personalDataService;

    @Mock
    private PersonalDataRepo personalDataRepo;
    @Mock
    private LoggingDataRepo loggingDataRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        personalDataService = new PersonalDataServiceImpl(personalDataRepo, loggingDataRepo);
    }

    @Test
    void shouldGetAllPersonalData() {
        //given
        LoggingDataEntity loggingDataEntityTest1 = LoggingDataEntity.builder().id(1L).build();
        LoggingDataEntity loggingDataEntityTest2 = LoggingDataEntity.builder().id(2L).build();

        PersonalDataEntity personalDataEntityTest1 = PersonalDataEntity.builder()
                .id(1L)
                .firstname("Test")
                .surname("Testowa")
                .phone(123456789)
                .email("test@test.pl")
                .loggingDataEntity(loggingDataEntityTest1)
                .build();

        PersonalDataEntity personalDataEntityTest2 = PersonalDataEntity.builder()
                .id(2L)
                .firstname("Tescik")
                .surname("Tescikowy")
                .phone(765234098)
                .email("tescik@test.pl")
                .loggingDataEntity(loggingDataEntityTest2)
                .build();

        List<PersonalDataEntity> personalDataEntityList = new ArrayList<>();
        personalDataEntityList.add(personalDataEntityTest1);
        personalDataEntityList.add(personalDataEntityTest2);

        when(personalDataRepo.findAll()).thenReturn(personalDataEntityList);
        //when
        List<PersonalData> allPersonalData = personalDataService.getAllPersonalData();
        //then
        Assertions.assertNotNull(allPersonalData); // czy nie jest nullem
        Assertions.assertEquals(2, allPersonalData.size()); // sprawdzam czy mam 2 testy

        Assertions.assertEquals(1L, allPersonalData.get(0).getPersonalDataId());
        Assertions.assertNotNull(allPersonalData.get(0));
        Assertions.assertEquals("Test", allPersonalData.get(0).getFirstname());
        Assertions.assertNotNull(allPersonalData.get(0).getFirstname());
        Assertions.assertEquals("Testowa", allPersonalData.get(0).getSurname());
        Assertions.assertNotNull(allPersonalData.get(0).getSurname());
        Assertions.assertEquals(123456789, allPersonalData.get(0).getPhone());
        Assertions.assertEquals("test@test.pl", allPersonalData.get(0).getEmail());
        Assertions.assertNotNull(allPersonalData.get(0).getEmail());
        Assertions.assertEquals(loggingDataEntityTest1.getId(), allPersonalData.get(0).getLoggingDataId());

        Assertions.assertEquals(2L, allPersonalData.get(1).getPersonalDataId());
        Assertions.assertEquals("Tescik", allPersonalData.get(1).getFirstname());
        Assertions.assertNotNull(allPersonalData.get(1).getFirstname());
        Assertions.assertEquals("Tescikowy", allPersonalData.get(1).getSurname());
        Assertions.assertNotNull(allPersonalData.get(1).getSurname());
        Assertions.assertEquals(765234098, allPersonalData.get(1).getPhone());
        Assertions.assertEquals("tescik@test.pl", allPersonalData.get(1).getEmail());
        Assertions.assertNotNull(allPersonalData.get(1).getEmail());
        Assertions.assertEquals(loggingDataEntityTest2.getId(), allPersonalData.get(1).getLoggingDataId());
    }

    @Test
    void getById() {
        //given
        LoggingDataEntity loggingDataEntityId = LoggingDataEntity.builder()
                .id(1L)
                .build();

        PersonalDataEntity personalDataEntity = PersonalDataEntity.builder()
                .id(1L)
                .firstname("Test")
                .surname("Testowy")
                .phone(111111111)
                .email("tescik@test.pl")
                .loggingDataEntity(loggingDataEntityId)
                .build();

        PersonalData personalDataExpected = PersonalData.builder()
                .build();

        when(personalDataRepo.findById(personalDataEntity.getId())).thenReturn(Optional.of(personalDataEntity));
        //when
        Optional<PersonalData> result = personalDataService.getById(personalDataEntity.getId());
        //then
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    void shouldGetBySurname() {
        //given
        LoggingDataEntity loggingDataEntityId = LoggingDataEntity.builder()
                .id(1L)
                .build();

        PersonalDataEntity personalDataEntity = PersonalDataEntity.builder()
                .id(1L)
                .firstname("Test")
                .surname("Testowy")
                .phone(111111111)
                .email("tescik@test.pl")
                .loggingDataEntity(loggingDataEntityId)
                .build();

        PersonalData personalDataExpect = PersonalData.builder()
                .build();

        when(personalDataRepo.findBySurname(personalDataExpect.getSurname())).thenReturn(Optional.of(personalDataEntity));

        //when
        List<PersonalData> personalDataBySurname = personalDataService.getBySurname(personalDataExpect.getSurname());
        //then
        Assertions.assertNotNull(personalDataBySurname, "Lista nie powinna być pusta");
        Assertions.assertEquals(1, personalDataBySurname.size(), "Lista owinna zawierać 1 element");
        Assertions.assertEquals("Test", personalDataBySurname.get(0).getFirstname());
    }

    @Test
    void shouldGetByEmail() {
        //given
        LoggingDataEntity loggingDataEntityId = LoggingDataEntity.builder()
                .id(1L)
                .build();

        PersonalData personalDataExpect = PersonalData.builder().build();

        PersonalDataEntity personalDataEntityTest = PersonalDataEntity.builder()
                .id(1L)
                .firstname("Test")
                .surname("Testowy")
                .phone(123456789)
                .email("test@testowy.pl")
                .loggingDataEntity(loggingDataEntityId)
                .build();

        when(personalDataRepo.findByEmail(personalDataExpect.getEmail())).thenReturn(Optional.of(personalDataEntityTest));
        //when
        List<PersonalData> personalDataByEmail = personalDataService.getByEmail(personalDataExpect.getEmail());
        //then
        Assertions.assertNotNull(personalDataByEmail, "Lista nie może być pusta");
        Assertions.assertEquals(1, personalDataByEmail.size(), "Lista powinna zawierać 1 element");
        Assertions.assertEquals("test@testowy.pl", personalDataByEmail.get(0).getEmail());
    }

    @Test
    void addPersonalData() {
        //given
        LoggingDataEntity loggingDataEntity = LoggingDataEntity.builder()
                .id(1L)
                .build();

        PersonalDataEntity personalDataEntityTest = PersonalDataEntity.builder()
                .id(1L)
                .firstname("Test")
                .surname("Testowy")
                .phone(123456789)
                .email("test@test.pl")
                .loggingDataEntity(loggingDataEntity)
                .build();

        PersonalData personalDataToBeAdded = PersonalData.builder()
                .firstname("Test")
                .surname("Testowy")
                .phone(123456789)
                .email("test@test.pl")
                .loggingDataId(1L)
                .build();

        when(loggingDataRepo.findById(any())).thenReturn(Optional.of(loggingDataEntity));
        when(personalDataRepo.save(any())).thenReturn(personalDataEntityTest);
        //when
        PersonalData result = personalDataService.addPersonalData(personalDataToBeAdded);
        //then
        Assertions.assertNotNull(result.getPersonalDataId());
    }

    @Test
    void modifySurname() {
    }

    @Test
    void modifyFirstname() {
    }

    @Test
    void modifyPhone() {
    }

    @Test
    void modifyEmail() {
    }

    @Test
    void delete() {
    }
}