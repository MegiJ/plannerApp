package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.exceptions.AccountDetailsException;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.utils.AccountDetailsConventerUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public AccountDetailsServiceImpl(AccountDetailsRepo accountDetailsRepo) {
        this.accountDetailsRepo = accountDetailsRepo;
    }

    @Override
    public List<AccountDetails> getAllAccounts() {
        return accountDetailsRepo.findAll().stream()
                .map(AccountDetailsConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Long addAccount(AccountDetails accountDetails) {

    }

    @Override
    public boolean deleteAccount(Long idToBeRemoved) {
        AccountDetailsEntity accountDetailsEntity = accountDetailsRepo.findById(idToBeRemoved)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        accountDetailsRepo.delete(accountDetailsEntity);
        return true;
    }

}
