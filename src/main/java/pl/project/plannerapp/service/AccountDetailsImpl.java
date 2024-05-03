package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.repo.AccountDetailsRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountDetailsImpl implements AccountDetailsService {
    private final AccountDetailsService accountDetailsService;
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public AccountDetailsImpl(AccountDetailsService accountDetailsService,
                              AccountDetailsRepo accountDetailsRepo) {
        this.accountDetailsRepo = accountDetailsRepo;
        this.accountDetailsService = accountDetailsService;
    }

    @Override
    public List<AccountDetailsDTO> getAll() {
        return accountDetailsRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }
}
