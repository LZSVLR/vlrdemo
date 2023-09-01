package com.vlr.vlrdemo.mapper;


import com.vlr.vlrdemo.dto.AccountDto;
import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.OrderBoost;
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
            .items(account.getItems().stream().map(itemMapper::map).collect(Collectors.toSet()))
            .balance(account.getBalance())
            .performOrderBoosts(account.getPerformOrderBoosts().stream().map(OrderBoost::getId).collect(Collectors.toList()))
            .assigneeOrderBoosts(account.getAssigneeOrderBoosts().stream().map(OrderBoost::getId).collect(Collectors.toList()))
            .build();
  }

  //Преобразует переданную стороннюю ДТОшку в клиента
  public Account map(AccountDto accountDto) {
    return Account.builder()
            .name(accountDto.getName())
            .phoneNumber(accountDto.getPhoneNumber())
//            .items(accountDto.getItems())
//            .performOrderBoosts(accountDto.getPerformOrderBoosts())
            .build();
  }

}
