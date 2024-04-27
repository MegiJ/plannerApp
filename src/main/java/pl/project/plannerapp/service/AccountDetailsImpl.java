package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;

@Service
public class AccountDetailsImpl implements AccountDetailsService {
    private final AccountDetailsService accountDetailsService;

    @Autowired
    public AccountDetailsImpl(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }
}
