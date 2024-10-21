package pl.project.plannerapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.repo.AccountDetailsRepo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    public void shouldGetAllAccounts() {
        //given
        List<AccountDetailsEntity> accountDetailsEntities = new ArrayList<>();
        accountDetailsEntities.add(AccountDetailsEntity.builder()
                .id(1L)
                .role("unicorn")
                .isExpired(false)
                .isLocked(false)
                .isCredentialsExpired(false)
                .isDisabled(true)
                .build());
        when(accountDetailsRepo.findAll()).thenReturn(accountDetailsEntities);
        //when
        List<AccountDetails> allAccounts = adsi.getAllAccounts();
        //then
        Assertions.assertEquals(1, allAccounts.size());
        Assertions.assertEquals(1L, allAccounts.get(0).getId());
        Assertions.assertEquals("unicorn", allAccounts.get(0).getRole());
        assertFalse(allAccounts.get(0).isExpired());
        assertFalse(allAccounts.get(0).isLocked());
        assertFalse(allAccounts.get(0).isCredentialsExpired());
        assertTrue(allAccounts.get(0).isDisabled());
    }
}
