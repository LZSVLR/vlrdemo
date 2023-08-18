package com.vlr.vlrdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_boost")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBoost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "OrderStatus")
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank")
    private Rank rank;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="performer_id")
    private Account performer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")

    private Account assignee;


}
