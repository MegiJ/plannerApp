package pl.project.plannerapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repositories.TestAccountDetailsRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;


class AccountDetailsServiceImplTest {
    private AccountDetailsRepo accountDetailsRepo;
    private AccountDetailsServiceImpl adsi;

    @BeforeEach
    public void setup() {
        accountDetailsRepo = new TestAccountDetailsRepo();
        adsi = new AccountDetailsServiceImpl(accountDetailsRepo);
    }

    @Test
    public void shouldGiveAllAccounts() {
        //given
        //when
        List<AccountDetails> result = adsi.getAllAccounts();
        //then
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(1L, result.get(0).getId());
        Assertions.assertEquals("unicorn", result.get(0).getRole());
        assertFalse(result.get(0).isExpired());
        assertFalse(result.get(0).isLocked());
        assertFalse(result.get(0).isCredentialsExpired());
        assertFalse(result.get(0).isDisabled());
    }

}