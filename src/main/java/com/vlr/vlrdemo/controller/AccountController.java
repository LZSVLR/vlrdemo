package com.vlr.vlrdemo.controller;

import com.vlr.vlrdemo.dto.AccountDto;
import com.vlr.vlrdemo.exception.CreateValidationException;
import com.vlr.vlrdemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/val")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/accounts")
  public ResponseEntity<List<AccountDto>> findAllAccounts()
  {
    return ResponseEntity.ok(accountService.findAllAccounts());
  }

  @GetMapping("/account/{id}")
  public ResponseEntity<AccountDto> findAccountById(@PathVariable Long id)
  {
    return ResponseEntity.ok(accountService.findAccountById(id));
  }

  @PostMapping("/create")
  public ResponseEntity<AccountDto> create(@RequestBody
                                                  AccountDto createAccountDto)  {
    if(createAccountDto.getName() == null & createAccountDto.getPhoneNumber() == null )
    {
      throw new CreateValidationException("Name can't be null");
    }

    return ResponseEntity.ok(accountService.createAccount(createAccountDto));
  }

  @PutMapping("/update")
    public ResponseEntity<AccountDto> update(@RequestBody AccountDto updateAccount)
  {
    return ResponseEntity.ok(accountService.updateAccount(updateAccount));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id)
  {
      accountService.deleteAccount(id);
      return ResponseEntity.ok("Deleted");
  }

}
