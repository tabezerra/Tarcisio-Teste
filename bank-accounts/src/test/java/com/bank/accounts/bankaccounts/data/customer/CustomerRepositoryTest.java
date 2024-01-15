package com.bank.accounts.bankaccounts.data.customer;

import com.bank.accounts.bankaccounts.domain.customer.Customer;
import com.bank.accounts.bankaccounts.domain.repositories.JpaCustomerRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class CustomerRepositoryTest {

    @Autowired
    JpaCustomerRepository jpaCustomerRepository;

    @Autowired
    EntityManager entityManager;

    Customer createCustumer(CustomerDto dto) {
        Customer newCustomer = new Customer(dto);
        this.entityManager.persist(newCustomer);
        return newCustomer;
    }

    @Test
    @DisplayName("Create and find Customer")
    void create() {
        CustomerDto request = new CustomerDto("User test", "PF",
                "11123470000", "Rua das avenidas", "123456789");

        Customer created = createCustumer(request);

        Optional<Customer> customerCreated = jpaCustomerRepository.findById(created.getId());
        assertThat(customerCreated.isPresent()).isTrue();
    }
}