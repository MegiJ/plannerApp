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

    public static final int PHONE_NUMBER_111 = 111111111;
    public static final String FIRSTNAME = "Test";
    public static final String SURNAME = "Testowa";
    public static final int PHONE_NUMBER_123 = 123456789;
    public static final String EMAIL = "test@test.pl";
    public static final long PERSONAL_DATA_ID = 1L;
    public static final long PERSONAL_DATA_ID_2 = 2L;
    private PersonalDataService personalDataService;

    @Mock
    private PersonalDataRepo personalDataRepo;
    @Mock
    private LoggingDataRepo loggingDataRepo;
    private LoggingDataEntity loggingDataEntityId;
    private PersonalDataEntity personalDataEntityBeforeUpdated;
    private PersonalDataEntity personalDataEntity1;

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
        personalDataEntity1 = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME)
                .surname(SURNAME)
                .phone(PHONE_NUMBER_111)
                .email(EMAIL)
                .loggingDataEntity(loggingDataEntityId)
                .build();
    }

    @Test
    void shouldGetAllPersonalData() {
        //given
        LoggingDataEntity loggingDataEntityTest2 = LoggingDataEntity.builder().id(PERSONAL_DATA_ID_2).build();

        PersonalDataEntity personalDataEntityTest2 = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID_2)
                .firstname(FIRSTNAME + "_2_test")
                .surname(SURNAME + "_2_test")
                .phone(PHONE_NUMBER_111)
                .email(EMAIL + "_2_test")
                .loggingDataEntity(loggingDataEntityTest2)
                .build();

        List<PersonalDataEntity> personalDataEntityList = new ArrayList<>();
        personalDataEntityList.add(personalDataEntity1);
        personalDataEntityList.add(personalDataEntityTest2);

        when(personalDataRepo.findAll()).thenReturn(personalDataEntityList);
        //when
        List<PersonalData> allPersonalData = personalDataService.getAllPersonalData();
        //then
        Assertions.assertNotNull(allPersonalData); // czy nie jest nullem
        Assertions.assertEquals(2, allPersonalData.size()); // sprawdzam czy mam 2 testy

        Assertions.assertEquals(PERSONAL_DATA_ID, allPersonalData.get(0).getPersonalDataId());
        Assertions.assertNotNull(allPersonalData.get(0));
        Assertions.assertEquals(FIRSTNAME, allPersonalData.get(0).getFirstname());
        Assertions.assertNotNull(allPersonalData.get(0).getFirstname());
        Assertions.assertEquals(SURNAME, allPersonalData.get(0).getSurname());
        Assertions.assertNotNull(allPersonalData.get(0).getSurname());
        Assertions.assertEquals(PHONE_NUMBER_111, allPersonalData.get(0).getPhone());
        Assertions.assertEquals(EMAIL, allPersonalData.get(0).getEmail());
        Assertions.assertNotNull(allPersonalData.get(0).getEmail());
        Assertions.assertEquals(loggingDataEntityId.getId(), allPersonalData.get(0).getLoggingDataId());

        Assertions.assertEquals(PERSONAL_DATA_ID_2, allPersonalData.get(1).getPersonalDataId());
        Assertions.assertEquals("Tescik", allPersonalData.get(1).getFirstname());
        Assertions.assertNotNull(allPersonalData.get(1).getFirstname());
        Assertions.assertEquals("Tescikowy", allPersonalData.get(1).getSurname());
        Assertions.assertNotNull(allPersonalData.get(1).getSurname());
        Assertions.assertEquals(PHONE_NUMBER_111, allPersonalData.get(1).getPhone());
        Assertions.assertEquals("tescik@test.pl", allPersonalData.get(1).getEmail());
        Assertions.assertNotNull(allPersonalData.get(1).getEmail());
        Assertions.assertEquals(loggingDataEntityTest2.getId(), allPersonalData.get(1).getLoggingDataId());
    }

    @Test
    void getById() {
        //given
        when(personalDataRepo.findById(personalDataEntity1.getId())).thenReturn(Optional.of(personalDataEntity1));
        //when
        Optional<PersonalData> result = personalDataService.getById(personalDataEntity1.getId());
        //then
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    void shouldGetBySurname() {
        //given
        PersonalData personalDataExpect = PersonalData.builder()
                .build();

        when(personalDataRepo.findBySurname(personalDataExpect.getSurname())).thenReturn(Optional.of(personalDataEntity1));

        //when
        List<PersonalData> personalDataBySurname = personalDataService.getBySurname(personalDataExpect.getSurname());
        //then
        Assertions.assertNotNull(personalDataBySurname, "Lista nie powinna być pusta");
        Assertions.assertEquals(1, personalDataBySurname.size(), "Lista owinna zawierać 1 element");
        Assertions.assertEquals(FIRSTNAME, personalDataBySurname.get(0).getFirstname());
    }

    @Test
    void shouldGetByEmail() {
        //given
        PersonalData personalDataExpect = PersonalData.builder().build();

        when(personalDataRepo.findByEmail(personalDataExpect.getEmail())).thenReturn(Optional.of(personalDataEntity1));
        //when
        List<PersonalData> personalDataByEmail = personalDataService.getByEmail(personalDataExpect.getEmail());
        //then
        Assertions.assertNotNull(personalDataByEmail, "Lista nie może być pusta");
        Assertions.assertEquals(1, personalDataByEmail.size(), "Lista powinna zawierać 1 element");
        Assertions.assertEquals(EMAIL, personalDataByEmail.get(0).getEmail());
    }

    @Test
    void addPersonalData() {
        //given
        PersonalData personalDataToBeAddedWithoutId = PersonalData.builder()
                .firstname(FIRSTNAME)
                .surname(SURNAME)
                .phone(PHONE_NUMBER_123)
                .email(EMAIL)
                .loggingDataId(PERSONAL_DATA_ID)
                .build();

        when(loggingDataRepo.findById(any())).thenReturn(Optional.of(loggingDataEntityId));
        when(personalDataRepo.save(any())).thenReturn(personalDataEntity1);
        //when
        PersonalData result = personalDataService.addPersonalData(personalDataToBeAddedWithoutId);
        //then
        Assertions.assertNotNull(result.getPersonalDataId());
    }

    @Test
    void modifySurname() {
        //given
        PersonalDataEntity beforeUpdate = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME)
                .surname(SURNAME)
                .phone(PHONE_NUMBER_123)
                .email(EMAIL)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        PersonalDataEntity personalDataEntityToBeUpdated = PersonalDataEntity.builder() // tu podajesz tylko te dane ktorych naprawde potrzebujesz; lub sprawdzasz czy sie zmienily lub nie
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME)
                .surname(SURNAME + "_2_test")
                .phone(PHONE_NUMBER_123)
                .email(EMAIL)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        when(personalDataRepo.findById(any())).thenReturn(Optional.of(beforeUpdate));
        when(personalDataRepo.save(eq(personalDataEntityToBeUpdated))).thenReturn(personalDataEntityToBeUpdated);
        //when
        PersonalData personalData = personalDataService.modifySurname(beforeUpdate.getId(), SURNAME + "_2_test");
        //then
        Assertions.assertEquals(SURNAME + "_2_test", personalData.getSurname());
    }

    @Test
    void modifyFirstname() {
        //given
        PersonalDataEntity personalDataEntityBeforeUpdate = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME)
                .surname(SURNAME)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        PersonalDataEntity personalDataEntityToBeUpdated = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .firstname(FIRSTNAME + "_2_test")
                .surname(SURNAME)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        when(personalDataRepo.findById(any())).thenReturn(Optional.of(personalDataEntityBeforeUpdate));
        when(personalDataRepo.save(eq(personalDataEntityToBeUpdated))).thenReturn(personalDataEntityToBeUpdated);
        //when
        PersonalData personalData = personalDataService.modifyFirstname(personalDataEntityBeforeUpdate.getId(), FIRSTNAME + "_2_test");
        //then
        Assertions.assertEquals(FIRSTNAME + "_2_test", personalData.getFirstname());

    }

    @Test
    void modifyPhone() {
        //given
        PersonalDataEntity personalDataEntityBeforeUpdated = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .phone(PHONE_NUMBER_111)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        PersonalDataEntity personalDataEntityToBeUpdated = PersonalDataEntity.builder()
                .id(PERSONAL_DATA_ID)
                .phone(PHONE_NUMBER_111 + 1)
                .loggingDataEntity(LoggingDataEntity.builder().id(PERSONAL_DATA_ID).build())
                .build();

        when(personalDataRepo.findById(any())).thenReturn(Optional.of(personalDataEntityBeforeUpdated));
        when(personalDataRepo.save(eq(personalDataEntityToBeUpdated))).thenReturn(personalDataEntityToBeUpdated);

        //when
        PersonalData personalData = personalDataService.modifyPhone(personalDataEntityBeforeUpdated.getId(), PHONE_NUMBER_111 + 1);

        //then
        Assertions.assertEquals(PHONE_NUMBER_111 + 1, personalData.getPhone());
    }

    @Test
    void modifyEmail() {
        //given
        PersonalDataEntity personalDataEntityBeforeUpdated = PersonalDataEntity.builder()
                .email(EMAIL)
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