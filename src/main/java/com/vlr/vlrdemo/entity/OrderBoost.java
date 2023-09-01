package com.vlr.vlrdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_boost")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBoost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank")
    private Rank rank;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_performer_id")
//    @JsonManagedReference
    private Account performer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_assignee_id")
//    @JsonManagedReference
    private Account assignee;


}
