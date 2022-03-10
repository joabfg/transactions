package com.pismo.transactions.repository;

import com.pismo.transactions.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public boolean existsByDocumentNumber(String documentNumber);
}
