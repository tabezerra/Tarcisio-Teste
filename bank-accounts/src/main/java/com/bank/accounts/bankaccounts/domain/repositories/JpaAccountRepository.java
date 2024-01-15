package com.bank.accounts.bankaccounts.domain.repositories;


import com.bank.accounts.bankaccounts.domain.account.Account;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, String> {

    boolean existsByCustomerAndAgency(Customer customer, String agency);

    boolean existsByAgency(String agency);
}
