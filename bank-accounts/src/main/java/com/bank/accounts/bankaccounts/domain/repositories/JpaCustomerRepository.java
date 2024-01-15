package com.bank.accounts.bankaccounts.domain.repositories;

import com.bank.accounts.bankaccounts.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRepository extends JpaRepository<Customer, String> {

    boolean existsByCpfCnpj(String cpfCnpj);
}
