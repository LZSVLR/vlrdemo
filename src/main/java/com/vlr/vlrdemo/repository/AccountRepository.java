package com.vlr.vlrdemo.repository;

import com.vlr.vlrdemo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long id);
    @Modifying
    @Query("UPDATE Account a set a.name = :name WHERE a.id = :id")
    Account updateAccountById(@Param("name") String name, @Param("id") Long id);
    void deleteAccountById(Long id);
}
