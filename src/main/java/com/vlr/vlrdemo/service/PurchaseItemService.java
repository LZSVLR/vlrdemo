package com.vlr.vlrdemo.service;


import com.vlr.vlrdemo.config.AppProperty;
import com.vlr.vlrdemo.dto.*;
import com.vlr.vlrdemo.entity.PaymentStatus;
import com.vlr.vlrdemo.entity.PurchaseOrder;
import com.vlr.vlrdemo.entity.PurchaseStatus;
import com.vlr.vlrdemo.exception.DataNotFoundException;
import com.vlr.vlrdemo.mapper.AccountMapper;
import com.vlr.vlrdemo.mapper.ItemMapper;
import com.vlr.vlrdemo.repository.AccountRepository;
import com.vlr.vlrdemo.repository.ItemRepository;
import com.vlr.vlrdemo.repository.PurchaseOrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

//Сервис который проверяет что есть такие товары
//Сервис который отвечает за отправку сообщений в payment
//Карту пользов. и сумму всех товаров которые он хочет купить и отправить в paYMENT
@Service
@RequiredArgsConstructor

public class PurchaseItemService {
    private final AppProperty appProperty;
    private final RestTemplate restTemplate;
    private final PurchaseOrderService purchaseOrderService;
    private final ItemService itemService;
    private final AccountService accountService;


    public PaymentStatus sendRequestCreatePaymentOrder(ReqPurchaseOrderDto reqPurchaseOrderDto)
    {
        var summary = 0.0;
        var requestItems = reqPurchaseOrderDto.getItems();
        var findAccount = accountService.findAccountById(reqPurchaseOrderDto.getAccountId());

        if(!Objects.equals(findAccount.getCreditCard(), reqPurchaseOrderDto.getCreditCard()))
            throw new DataNotFoundException("Указаная карта не привязана к аккауну");

        var availableItemsDto = itemService.checkAvailabilityItemsById(reqPurchaseOrderDto.getItems());


        //Подсчет суммы исходя из кол-ва запрашиваемых доступных товаров
        //Добавать проверку кол-ва товаров
        //SELECT SUM() ИСПРАВИТЬ
        for(RequestItemsDto reqItems: requestItems)
        {
            long itemIdDto = reqItems.getItemId();
            int reqCount = (int) reqItems.getCount();
            for(ItemDto availebleItemDto: availableItemsDto)
            {
                if(availebleItemDto.getId() == itemIdDto)
                {
                    summary = summary + availebleItemDto.getPrice()*reqCount;

                }
            }
        }

        PaymentDataDto paymentDataDto = new PaymentDataDto();
        paymentDataDto.setCardNumber(reqPurchaseOrderDto.getCreditCard());
        paymentDataDto.setSummary(summary);
        PaymentStatus response;
       try
       {  response = restTemplate.postForObject(appProperty.getPaymentUrl(),paymentDataDto, PaymentStatus.class); }
       catch (HttpClientErrorException.BadRequest e)
       {
           response = PaymentStatus.FAILED;
       }

        switch (Objects.requireNonNull(response))
       {
           //Не сделано, т.к не списать с остатков//не посмотреть кол-во item в заказе
           case FAILED -> {System.out.println("FAILED");}
           case COMPLETED ->
           {
               var newOrder = new PurchaseOrder();
               //Как уменьшить кол-во?
               newOrder.setItems(itemService.getItemsById(requestItems));
               newOrder.setOrderPrice(summary);
               newOrder.setAccount(accountService.getAccountId(reqPurchaseOrderDto.getAccountId()));
               newOrder.setPurchaseStatus(PurchaseStatus.COMPLETED);
               purchaseOrderService.createOrder(newOrder);
           }
           case CANCEL -> System.out.println("CANCEL");
       };
       return response;
    }


}
