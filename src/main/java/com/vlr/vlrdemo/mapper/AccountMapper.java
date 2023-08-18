package com.vlr.vlrdemo.mapper;


import com.vlr.vlrdemo.dto.AccountDto;
import com.vlr.vlrdemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
//map struct
public class AccountMapper {

  //Преобразует клиента в ДТОшку
  public AccountDto map(Account account) {
    return AccountDto.builder()
            .id(account.getId())
            .name(account.getName())
            .phoneNumber(account.getPhoneNumber())
            .items(account.getItems())
            .balance(account.getBalance())
            .performOrderBoosts(account.getPerformOrderBoosts())
            .assigneeOrderBoosts(account.getAssigneeOrderBoosts())
            .build();
  }

  //Преобразует переданную стороннюю ДТОшку в клиента
  public Account map(AccountDto accountDto) {
    return Account.builder()
            .name(accountDto.getName())
            .phoneNumber(accountDto.getPhoneNumber())
            .build();
  }
}
