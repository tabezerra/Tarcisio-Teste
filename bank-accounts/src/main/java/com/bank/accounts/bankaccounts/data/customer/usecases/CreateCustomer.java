package com.bank.accounts.bankaccounts.data.customer.usecases;

import com.bank.accounts.bankaccounts.data.customer.CustomerDto;
import com.bank.accounts.bankaccounts.data.customer.CustomerRepository;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomer {
    @Autowired
    private CustomerRepository repository;

    public Customer handle(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto);
        return repository.create(customer);
    }

}
