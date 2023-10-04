package com.vlr.vlrdemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "purchase_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_price")
    private Double orderPrice;

    @Column(name = "purchase_status")
    @Enumerated(EnumType.STRING)
    private PurchaseStatus purchaseStatus;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

        @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_items",
            joinColumns = @JoinColumn(name = "purchase_order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Item> items;

}
