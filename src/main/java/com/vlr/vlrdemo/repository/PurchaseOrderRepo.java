package com.vlr.vlrdemo.repository;

import com.vlr.vlrdemo.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Long> {

    //Сделать селект по id, далее в коде вытащить из полученной сущности лист товаров
}
