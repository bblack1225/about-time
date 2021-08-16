package com.blake.yu.dao.repository;

import com.blake.yu.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByEmail(String email);

    @Query(value = "SELECT a FROM Account a" +
            " WHERE a.inviteCode = :inviteCode" +
            " AND a.isEnable = 1")
    Optional<Account> queryByInviteCodeAndStatus(String inviteCode);
}
