package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.AccountDetailsDTO;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.service.AccountDetailsService;
import pl.project.plannerapp.utils.AccountDetailsConventerUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accountDetails", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountDetailsController {
    private final AccountDetailsService accountDetailsService;

    @Autowired
    public AccountDetailsController(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @GetMapping
    public List<AccountDetailsDTO> getAll() {
        List<AccountDetails> accountDetails = accountDetailsService.getAllAccounts();
        return accountDetails.stream().map(AccountDetailsConventerUtils::convert).toList();
    }

    @PostMapping
    public ResponseEntity<String> createAccountDetails(@RequestBody AccountDetailsDTO accountDetailsJson) {
        Long accountDetailsId = accountDetailsService.addAccount(AccountDetailsConventerUtils.convert(accountDetailsJson)).getId();
        return new ResponseEntity<>("{\"id\":\"" + accountDetailsId + "\"}", HttpStatus.CREATED);
    }

    @DeleteMapping("/{accountDetailsId}")
    public void deleteAccountDetails(@PathVariable Long accountDetailsId) {
        accountDetailsService.deleteAccount(accountDetailsId);
    }
}
