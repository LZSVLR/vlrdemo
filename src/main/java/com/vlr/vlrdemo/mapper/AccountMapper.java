package com.vlr.vlrdemo.mapper;


import com.vlr.vlrdemo.dto.AccountDto;
import com.vlr.vlrdemo.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
//map struct
public class AccountMapper {
  private final ItemMapper itemMapper;

  //Преобразует клиента в ДТОшку
  public AccountDto map(Account account) {

    return AccountDto.builder()
            .id(account.getId())
            .name(account.getName())
            .phoneNumber(account.getPhoneNumber())
            .creditCard(account.getCreditCard())
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
