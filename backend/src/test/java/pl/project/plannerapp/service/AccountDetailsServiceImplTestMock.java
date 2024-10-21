package pl.project.plannerapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.repo.AccountDetailsRepo;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class AccountDetailsServiceImplTestMock {
    @Mock
    private AccountDetailsRepo accountDetailsRepo;
    private AccountDetailsServiceImpl adsi;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        adsi = new AccountDetailsServiceImpl(accountDetailsRepo);
    }

    @Test
    public void shouldAddAccount() {
        //given
        long accountEntityDetailsId = 123L;
        AccountDetailsEntity accountDetailsEntity = AccountDetailsEntity.builder().id(accountEntityDetailsId).build();
        AccountDetailsEntity accountDetailsEntityTransformed = AccountDetailsEntity.builder().isDisabled(true).build(); // wynik metody convert
        when(accountDetailsRepo.save(eq(accountDetailsEntityTransformed))).thenReturn(accountDetailsEntity);
        AccountDetails accountDetails = AccountDetails.builder().isDisabled(true).build();
        //when
        Long result = adsi.addAccount(accountDetails);
        //then
        Assertions.assertEquals(accountEntityDetailsId, result);
    }
}
