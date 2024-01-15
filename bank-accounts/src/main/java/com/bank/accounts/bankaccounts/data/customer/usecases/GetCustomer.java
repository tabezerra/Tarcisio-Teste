package com.bank.accounts.bankaccounts.data.customer.usecases;

import com.bank.accounts.bankaccounts.data.customer.CustomerRepository;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCustomer {

    @Autowired
    private CustomerRepository repository;

    public Optional<Customer> handle(String id) {
        Optional<Customer> customer = repository.get(id);
        if(customer.isPresent()) {
            return Optional.of(customer.get());
        }

        return Optional.empty();
    }
}
