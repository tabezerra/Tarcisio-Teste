package com.bank.accounts.bankaccounts.domain.customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICustomerRepository {

    Customer create(Customer customer);

    Optional<Customer> get(String id);

    List<Customer> getAll();

    Optional<Customer> update(String id, Customer customer);

    void delete(String id);

    Optional<Customer> patch(String id, Map<String, Object> fields);
}
