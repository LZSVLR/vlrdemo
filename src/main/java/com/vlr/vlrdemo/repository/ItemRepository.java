package com.vlr.vlrdemo.repository;


import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemById(Long id );
    void deleteItemById(Long id);
    @Modifying
    @Query("UPDATE Item i set i.name = :name, i.price = :price, i.description = :description WHERE i.id = :id")
    Account updateItemById(@Param("name") String name,
                           @Param("price") Double price,
                           @Param("description") String description,
                           @Param("id") Long id);
}
