package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.AccountDetailsDTO;

import java.util.List;
import java.util.Optional;

public interface AccountDetailsService {
    List<AccountDetailsDTO> getAll();

    void put(Long id, AccountDetailsDTO accountDetailsDTO);

    void delete(Long id);

    Optional<AccountDetailsDTO> getById(Long id);

}
