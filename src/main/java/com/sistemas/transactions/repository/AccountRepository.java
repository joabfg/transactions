package com.sistemas.transactions.repository;

import com.sistemas.transactions.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public boolean existsByDocumentNumber(String documentNumber);
}
