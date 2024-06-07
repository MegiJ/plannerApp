package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.model.AccountDetails;

import java.util.List;
import java.util.Optional;

public interface AccountDetailsService {
    List<AccountDetails> getAllAccount();

    void put(Long id, AccountDetailsDTO accountDetailsDTO);

    void deleteAccount(Long id);

    Optional<AccountDetails> getById(Long id);

}
