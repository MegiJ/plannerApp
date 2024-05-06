package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.service.AccountDetailsService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accountDetails", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountDetailsController {
    interface AccountDetailsView extends AccountDetailsDTO.View.Basic {}

    private final AccountDetailsService accountDetailsService;

    @Autowired
    public AccountDetailsController(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @GetMapping
    public List<AccountDetailsDTO> get() {
        return accountDetailsService.getAll();
    }

    @GetMapping("/{accountDetails-id}")
    public AccountDetailsDTO get(@PathVariable Long id) {
        return accountDetailsService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @PutMapping("/{accountDetails-id)")
    public void put (@PathVariable Long id, @RequestBody AccountDetailsDTO accountDetailsJson) {
        accountDetailsService.put(id, accountDetailsJson);
    }

    @Transactional
    @DeleteMapping("/{accountDetails-id}")
    public void delete(@PathVariable Long id) {
        accountDetailsService.delete(id);
    }
}
