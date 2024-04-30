package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.service.AccountDetailsService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accountDetails", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountDetailsController {
    interface AccountDetailsView extends AccountDetailsDTO.View.Basic {}
    interface Account
    private final AccountDetailsService accountDetailsService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public AccountDetailsController(AccountDetailsService accountDetailsService, ApplicationEventPublisher applicationEventPublisher) {
        this.accountDetailsService = accountDetailsService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping
    public List<AccountDetailsDTO> get() {
        return null;
    }

    @GetMapping("/{accountDetails-id}")
    public AccountDetailsDTO get(@PathVariable int id) {
        return null;
    }

    @Transactional
    @PutMapping("/{accountDetails-id)")
    public void put (@PathVariable int id, @RequestBody AccountDetailsDTO accountDetailsJson) {

    }

    @Transactional
    @DeleteMapping("/{accountDetails-id}")
    public void delete(@PathVariable int id) {

    }
}
