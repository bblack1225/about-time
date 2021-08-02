package com.blake.yu.dao.repository;

import com.blake.yu.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByEmail(String email);
}
