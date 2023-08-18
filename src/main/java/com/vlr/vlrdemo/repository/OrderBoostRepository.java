package com.vlr.vlrdemo.repository;

import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.OrderBoost;
import com.vlr.vlrdemo.entity.OrderStatus;
import com.vlr.vlrdemo.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBoostRepository extends JpaRepository<OrderBoost, Long> {
    OrderBoost findOrderBoostById(Long id);
    void deleteOrderBoostById(Long id);
    List<OrderBoost> findAllByOrderStatus(OrderStatus orderStatus);
    @Modifying
    @Query("UPDATE OrderBoost o set o.rank = :rank, o.price = :price, o.description = :description WHERE o.id = :id")
    OrderBoost updateOrderBoostById(@Param("rank") Rank rank,
                           @Param("price") Double price,
                           @Param("description") String description,
                           @Param("id") Long id);


}
