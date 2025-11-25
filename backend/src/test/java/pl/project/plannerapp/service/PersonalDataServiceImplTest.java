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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PersonalDataServiceImplTest {

    public static final int PHONE_TWO = 111111111;
    public static final String FIRSTNAME_ONE = "Test";
    public static final String SURNAME_ONE = "Testowa";
    public static final int PHONE_ONE = 123456789;
    public static final String EMAIL_ONE = "test@test.pl";
    public static final long PERSONAL_DATA_ID = 1L;
    private PersonalDataService personalDataService;

    @Mock
    private PersonalDataRepo personalDataRepo;
    @Mock
    private LoggingDataRepo loggingDataRepo;
    private LoggingDataEntity loggingDataEntityId;
    private PersonalDataEntity personalDataEntityBeforeUpdated;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        personalDataService = new PersonalDataServiceImpl(personalDataRepo, loggingDataRepo);
        loggingDataEntityId = LoggingDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .build();
        personalDataEntityBeforeUpdated = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .build();
    }

    @Test
    void shouldGetAllPersonalData() {
        //given

        LoggingDataEntity loggingDataEntityTest2 = LoggingDataEntity.builder().id(2L).build();

        PersonalDataEntity personalDataEntityTest1 = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .phone(PHONE_TWO)
                .email(EMAIL_ONE)
                .loggingDataEntity(loggingDataEntityId)
                .build();

        PersonalDataEntity personalDataEntityTest2 = PersonalDataEntity.builder()
                .id(2L)
                .firstname("Tescik")
                .surname("Tescikowy")
                .phone(PHONE_TWO)
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

        Assertions.assertEquals(PERSONAL_DATA_ID, allPersonalData.get(0).getPersonalDataId());
        Assertions.assertNotNull(allPersonalData.get(0));
        Assertions.assertEquals(FIRSTNAME_ONE, allPersonalData.get(0).getFirstname());
        Assertions.assertNotNull(allPersonalData.get(0).getFirstname());
        Assertions.assertEquals(SURNAME_ONE, allPersonalData.get(0).getSurname());
        Assertions.assertNotNull(allPersonalData.get(0).getSurname());
        Assertions.assertEquals(PHONE_TWO, allPersonalData.get(0).getPhone());
        Assertions.assertEquals(EMAIL_ONE, allPersonalData.get(0).getEmail());
        Assertions.assertNotNull(allPersonalData.get(0).getEmail());
        Assertions.assertEquals(loggingDataEntityId.getId(), allPersonalData.get(0).getLoggingDataId());

        Assertions.assertEquals(2L, allPersonalData.get(1).getPersonalDataId());
        Assertions.assertEquals("Tescik", allPersonalData.get(1).getFirstname());
        Assertions.assertNotNull(allPersonalData.get(1).getFirstname());
        Assertions.assertEquals("Tescikowy", allPersonalData.get(1).getSurname());
        Assertions.assertNotNull(allPersonalData.get(1).getSurname());
        Assertions.assertEquals(PHONE_TWO, allPersonalData.get(1).getPhone());
        Assertions.assertEquals("tescik@test.pl", allPersonalData.get(1).getEmail());
        Assertions.assertNotNull(allPersonalData.get(1).getEmail());
        Assertions.assertEquals(loggingDataEntityTest2.getId(), allPersonalData.get(1).getLoggingDataId());
    }

    @Test
    void getById() {
        //given
        PersonalDataEntity personalDataEntity = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .phone(PHONE_TWO)
                .email(EMAIL_ONE)
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
        PersonalDataEntity personalDataEntity = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .phone(PHONE_TWO)
                .email(EMAIL_ONE)
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
        Assertions.assertEquals(FIRSTNAME_ONE, personalDataBySurname.get(0).getFirstname());
    }

    @Test
    void shouldGetByEmail() {
        //given
        PersonalData personalDataExpect = PersonalData.builder().build();

        PersonalDataEntity personalDataEntityTest = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .phone(PHONE_ONE)
                .email(EMAIL_ONE)
                .loggingDataEntity(loggingDataEntityId)
                .build();

        when(personalDataRepo.findByEmail(personalDataExpect.getEmail())).thenReturn(Optional.of(personalDataEntityTest));
        //when
        List<PersonalData> personalDataByEmail = personalDataService.getByEmail(personalDataExpect.getEmail());
        //then
        Assertions.assertNotNull(personalDataByEmail, "Lista nie może być pusta");
        Assertions.assertEquals(1, personalDataByEmail.size(), "Lista powinna zawierać 1 element");
        Assertions.assertEquals(EMAIL_ONE, personalDataByEmail.get(0).getEmail());
    }

    @Test
    void addPersonalData() {
        //given
        PersonalDataEntity personalDataEntityTest = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .phone(PHONE_ONE)
                .email(EMAIL_ONE)
                .loggingDataEntity(loggingDataEntityId)
                .build();

        PersonalData personalDataToBeAdded = PersonalData.builder()
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .phone(PHONE_ONE)
                .email(EMAIL_ONE)
                .loggingDataId(PERSONAL_DATA_ID)
                .build();

        when(loggingDataRepo.findById(any())).thenReturn(Optional.of(loggingDataEntityId));
        when(personalDataRepo.save(any())).thenReturn(personalDataEntityTest);
        //when
        PersonalData result = personalDataService.addPersonalData(personalDataToBeAdded);
        //then
        Assertions.assertNotNull(result.getPersonalDataId());
    }

    @Test
    void modifySurname() {
        //given
        PersonalDataEntity beforeUpdate = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .phone(PHONE_ONE)
                .email(EMAIL_ONE)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        PersonalDataEntity personalDataEntityToBeUpdated = PersonalDataEntity.builder() // tu podajesz tylko te dane ktorych naprawde potrzebujesz; lub sprawdzasz czy sie zmienily lub nie
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname("Testowyyyy")
                .phone(PHONE_ONE)
                .email(EMAIL_ONE)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        when(personalDataRepo.findById(any())).thenReturn(Optional.of(beforeUpdate));
        when(personalDataRepo.save(eq(personalDataEntityToBeUpdated))).thenReturn(personalDataEntityToBeUpdated);
        //when
        PersonalData personalData = personalDataService.modifySurname(beforeUpdate.getId(), "Testowyyyy");
        //then
        Assertions.assertEquals("Testowyyyy", personalData.getSurname());
    }

    @Test
    void modifyFirstname() {
        //given
        PersonalDataEntity personalDataEntityBeforeUpdate = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME_ONE)
                .surname(SURNAME_ONE)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        PersonalDataEntity personalDataEntityToBeUpdated = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname("Testttt")
                .surname(SURNAME_ONE)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        when(personalDataRepo.findById(any())).thenReturn(Optional.of(personalDataEntityBeforeUpdate));
        when(personalDataRepo.save(eq(personalDataEntityToBeUpdated))).thenReturn(personalDataEntityToBeUpdated);
        //when
        PersonalData personalData = personalDataService.modifyFirstname(personalDataEntityBeforeUpdate.getId(), "Testttt");
        //then
        Assertions.assertEquals("Testttt", personalData.getFirstname());

    }

    @Test
    void modifyPhone() {
        //given
        PersonalDataEntity personalDataEntityBeforeUpdated = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .phone(PHONE_TWO)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        PersonalDataEntity personalDataEntityToBeUpdated = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .phone(000000000)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        when(personalDataRepo.findById(any())).thenReturn(Optional.of(personalDataEntityBeforeUpdated));
        when(personalDataRepo.save(eq(personalDataEntityToBeUpdated))).thenReturn(personalDataEntityToBeUpdated);

        //when
        PersonalData personalData = personalDataService.modifyPhone(personalDataEntityBeforeUpdated.getId(), 000000000);

        //then
        Assertions.assertEquals(000000000, personalData.getPhone());
    }

    @Test
    void modifyEmail() {
        //given
        PersonalDataEntity personalDataEntityBeforeUpdated = PersonalDataEntity.builder()
                .email(EMAIL_ONE)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        PersonalDataEntity personalDataEntityToBeUpdated = PersonalDataEntity.builder()
                .email("ttt@test.pl")
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        List<PersonalDataEntity> personalDataEntityList = new ArrayList<>();
        personalDataEntityList.add(personalDataEntityBeforeUpdated);

        when(personalDataRepo.findById(any())).thenReturn(Optional.of(personalDataEntityBeforeUpdated));
        when(personalDataRepo.findAll()).thenReturn(personalDataEntityList);
        when(personalDataRepo.save(personalDataEntityBeforeUpdated)).thenReturn(personalDataEntityToBeUpdated);

        //when
        PersonalData personalData = personalDataService.modifyEmail(personalDataEntityToBeUpdated.getId(), "ttt@test.pl");

        //then
        Assertions.assertEquals("ttt@test.pl", personalData.getEmail());
    }

    @Test
    void delete() {
        //given
        when(personalDataRepo.findById(PERSONAL_DATA_ID)).thenReturn(Optional.of(personalDataEntityBeforeUpdated));

        //when
        personalDataService.delete(PERSONAL_DATA_ID);

        //then
        verify(personalDataRepo, times(1)).delete(personalDataEntityBeforeUpdated);
    }
}