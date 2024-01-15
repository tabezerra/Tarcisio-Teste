package com.bank.accounts.bankaccounts.data.account;

import com.bank.accounts.bankaccounts.data.customer.CustomerDto;
import com.bank.accounts.bankaccounts.domain.account.Account;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import com.bank.accounts.bankaccounts.domain.repositories.JpaAccountRepository;
import com.bank.accounts.bankaccounts.domain.repositories.JpaCustomerRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class AccountRepositoryTest {

    @Autowired
    JpaAccountRepository jpaAccountRepository;

    @Autowired
    JpaCustomerRepository jpaCustomerRepository;

    @Autowired
    EntityManager entityManager;

    Account createAccount(AccountDto dto, Customer customer) {
        Account newAccount = new Account(dto, customer);
        this.entityManager.persist(newAccount);
        return newAccount;
    }

    Customer createCustumer(CustomerDto dto) {
        Customer newCustomer = new Customer(dto);
        this.entityManager.persist(newCustomer);
        return newCustomer;
    }


    @Test
    @DisplayName("Create Customer, find and create Account")
    void create() {
        CustomerDto request = new CustomerDto("User test", "PF",
                "11123470000", "Rua das avenidas", "123456789");

        Customer createdCustomer = createCustumer(request);

        Optional<Customer> customerCreated = jpaCustomerRepository.findById(createdCustomer.getId());
        assertThat(customerCreated.isPresent()).isTrue();

        AccountDto accountDto = new AccountDto(createdCustomer.getId(), "100", 100f, "Active");
        Account newAccount = createAccount(accountDto, createdCustomer);

        Optional<Account> accountCreated = jpaAccountRepository.findById(newAccount.getId());
        assertThat(accountCreated.isPresent()).isTrue();
    }
}