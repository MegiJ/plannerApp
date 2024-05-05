package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.repo.AccountDetailsRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public AccountDetailsServiceImpl(AccountDetailsRepo accountDetailsRepo) {
        this.accountDetailsRepo = accountDetailsRepo;
    }

    @Override
    public List<AccountDetails> getAll() {
        return accountDetailsRepo.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void put(Long id, AccountDetailsDTO accountDetailsDTO) {

    }

    @Override
    public void delete(Long id) {
        AccountDetails accountDetails = accountDetailsRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        accountDetailsRepo.delete(accountDetails);
    }

    @Override
    public Optional<AccountDetails> getById(Long id) {
        return accountDetailsRepo.findById(id);
    }
}
