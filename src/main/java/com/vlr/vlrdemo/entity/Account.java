package com.vlr.vlrdemo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "account")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phoneNumber;
    //инициализация

    @Column(name = "credit_card")
    private String creditCard;

    @OneToMany(mappedBy = "account")
    private Set<PurchaseOrder> purchaseOrders;

//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "order_items",
//            joinColumns = @JoinColumn(name = "account_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id"))
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//
//    private Set<Item> items;



//    Lombok + hiber
//    LazyInitExc

}