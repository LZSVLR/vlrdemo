package com.vlr.vlrdemo.repository;


import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemById(Long id );
    void deleteItemById(Long id);
    @Modifying
    @Query("UPDATE Item i set i.name = :name, i.price = :price, i.description = :description WHERE i.id = :id")
    Item updateItemById(@Param("name") String name,
                           @Param("price") Double price,
                           @Param("description") String description,
                           @Param("id") Long id);
    //Метод `findExistingIds` будет возвращать список существующих идентификаторов из переданного списка.
    //Если некоторые идентификаторы отсутствуют в базе данных, они не будут возвращены в результирующем списке.

//    @Transactional
//    @Modifying
//    @Query("UPDATE  Item i set i.value = i.value - :item.value WHERE i.id IN :items")
//    void resetValueItems(@Param("items") List<Item> items);


    @Query("SELECT i FROM Item i WHERE i.id IN :ids")
    List<Item> findExistingIds(@Param("ids") List<Long> ids);
    //Этот запрос вернет количество существующих записей с идентификаторами из списка ids. Если результат больше нуля, то существуют соответствующие записи.
    @Query("SELECT COUNT(i) FROM Item i WHERE i.id IN :ids")
    default void findItemsByIdS(@Param("ids") List<Long> ids){};

}
