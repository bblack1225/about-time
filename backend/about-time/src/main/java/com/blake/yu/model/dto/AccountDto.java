package com.blake.yu.model.dto;

import com.blake.yu.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDto extends JpaRepository<Account,Integer> {
}
