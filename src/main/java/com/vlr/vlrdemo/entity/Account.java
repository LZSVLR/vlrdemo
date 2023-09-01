package com.vlr.vlrdemo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account")
@Data
@Builder
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

    //не может быть отрицательным
    @Column(name = "balance")
    private Double balance;


    @OneToMany(mappedBy = "performer", fetch = FetchType.EAGER)
//    @JsonBackReference
    private List<OrderBoost> performOrderBoosts;

    @OneToMany(mappedBy = "assignee", fetch = FetchType.EAGER)
//    @JsonBackReference
    private List<OrderBoost> assigneeOrderBoosts;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_items",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
//    @JsonBackReference
    private Set<Item> items;



//    Lombok + hiber
//    LazyInitExc

}