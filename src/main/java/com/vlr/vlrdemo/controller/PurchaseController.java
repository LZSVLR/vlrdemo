package com.vlr.vlrdemo.controller;

import com.vlr.vlrdemo.dto.ReqPurchaseOrderDto;
import com.vlr.vlrdemo.entity.PaymentStatus;
import com.vlr.vlrdemo.service.PurchaseItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Создать контроллер который отвечает за покупку товара
//Нужно чтобы контроллер принимал List<ID товаров>
//Проверить что такие товары существуют

//+++purchase_order модель, она содержит List<PurchaseItems>,
//+++PurchaseItems содержит Long itemId Long count

//Сервис который проверяет что есть такие товары
//Сервис который отвечает за отправку сообщений в payment
//Карту пользов. и сумму всех товаров которые он хочет купить и отправить в paYMENT
@RestController
@RequestMapping("api/demo/purchase")
@RequiredArgsConstructor
@Slf4j
public class PurchaseController {
   private final PurchaseItemService purchaseItemService;

    @PostMapping("/createOrder")
    public ResponseEntity<PaymentStatus> createOrder(@RequestBody
                                                     ReqPurchaseOrderDto reqPurchaseOrderDto) {
       PaymentStatus payment =  purchaseItemService.sendRequestCreatePaymentOrder(reqPurchaseOrderDto);
        //CreateOrder
        return ResponseEntity.ok(payment);


    }
}

