package pl.project.plannerapp.service;

import pl.project.plannerapp.model.AccountDetails;

import java.util.List;

public interface AccountDetailsService {
    List<AccountDetails> getAllAccounts(); // lista kont

    AccountDetails addAccount(AccountDetails accountDetails);

    boolean deleteAccount(Long idToBeRemoved);

    List<AccountDetails> getAllExpiredAccounts();

}
