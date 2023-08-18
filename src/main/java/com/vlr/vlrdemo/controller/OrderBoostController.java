package com.vlr.vlrdemo.controller;

import com.vlr.vlrdemo.dto.AccountDto;
import com.vlr.vlrdemo.dto.OrderBoostDto;
import com.vlr.vlrdemo.exception.CreateValidationException;
import com.vlr.vlrdemo.service.AccountService;
import com.vlr.vlrdemo.service.OrderBoostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/val/OrdersForBoost")
@RequiredArgsConstructor
@Slf4j
public class OrderBoostController {
    private final OrderBoostService orderBoostService;

    //ошибка
    @GetMapping("/all")
    public ResponseEntity<List<OrderBoostDto>> findAllOrders()
    {
        return ResponseEntity.ok(orderBoostService.findAllOrderBoosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderBoostDto> findOrderBoostById(@PathVariable Long id)
    {
        return ResponseEntity.ok(orderBoostService.findOrderBoostById(id));
    }
//
    @PostMapping("/create")
    public ResponseEntity<OrderBoostDto> create(@RequestBody
                                                    OrderBoostDto orderBoostDto)  {
        if(orderBoostDto.getRank() == null & orderBoostDto.getPrice() == null)
        {
            throw new CreateValidationException("Name can't be null");
        }

        return ResponseEntity.ok(orderBoostService.createOrderBoost(orderBoostDto));
    }
//
    @PutMapping("/update")
    public ResponseEntity<OrderBoostDto> update(@RequestBody OrderBoostDto orderBoostDto)
    {
        return ResponseEntity.ok(orderBoostService.updateOrderBoost(orderBoostDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        orderBoostService.deleteOrderBoost(id);
        return ResponseEntity.ok("Deleted");
    }
}
