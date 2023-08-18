//package com.vlr.vlrdemo.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "ref_account")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class RefAccount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_id", referencedColumnName = "id")
//    Long accountID;
//}
