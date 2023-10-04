package com.vlr.vlrdemo.service;

import com.vlr.vlrdemo.dto.PurchaseOrderDto;
import com.vlr.vlrdemo.entity.PurchaseOrder;
import com.vlr.vlrdemo.mapper.PurchaseOrderMapper;
import com.vlr.vlrdemo.repository.PurchaseOrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {
    private final PurchaseOrderRepo purchaseOrderRepo;
    private final PurchaseOrderMapper purchaseOrderMapper;

    public void createOrder(PurchaseOrder purchaseOrder)
    {
        //Добавить проверку
        purchaseOrderRepo.save(purchaseOrder);
    }


}
