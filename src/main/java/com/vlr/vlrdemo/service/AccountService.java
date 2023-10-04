package com.vlr.vlrdemo.service;


import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.exception.DataNotFoundException;
import com.vlr.vlrdemo.mapper.AccountMapper;
import com.vlr.vlrdemo.repository.AccountRepository;
import com.vlr.vlrdemo.dto.AccountDto;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public List<AccountDto> findAllAccounts()
    {
        return  accountRepository.findAll().stream().map(accountMapper::map).collect(Collectors.toList());
    }

    public AccountDto findAccountById(Long id)
    {
        var userAccount = new Account();
        Optional<Account> findAccount = Optional.ofNullable(accountRepository.searchAccountById(id));
        if(findAccount.isPresent())
        {
            userAccount = findAccount.get();


        }else throw new DataNotFoundException("Указаный аккаунт не существует");

        return accountMapper.map(userAccount);

    }
    public Account getAccountId(Long id)
    {
        var userAccount = new Account();
        Optional<Account> findAccount = Optional.ofNullable(accountRepository.searchAccountById(id));
        if (findAccount.isPresent()) {
            userAccount = findAccount.get();


        } else throw new DataNotFoundException("Указаный аккаунт не существует");

        return userAccount;
    }
    public AccountDto createAccount(AccountDto accountDto) {
        var created = accountRepository.save(accountMapper.map(accountDto));
        return accountMapper.map(created);
    }
    public AccountDto updateAccount(AccountDto accountDto)
    {
        if (accountRepository.findById(accountDto.getId()).isEmpty())
        {
            throw new DataNotFoundException("Account not found!");
        }
        var update = accountRepository.updateAccountById(accountDto.getName(), accountDto.getId());
        return accountMapper.map(update);
    }

    @Transactional
    public void deleteAccount(Long id)
    {
        if (accountRepository.findById(id).isEmpty())
            {
                throw new DataNotFoundException("Account not found!");
            }
        else
        {
//        var deleted = accountMapper.map(accountRepository.findAccountById(id));
        accountRepository.deleteAccountById(id);
//        return deleted;
        }

    }

}

