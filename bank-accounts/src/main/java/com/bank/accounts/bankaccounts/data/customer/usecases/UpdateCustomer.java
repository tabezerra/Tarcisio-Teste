package com.bank.accounts.bankaccounts.data.customer.usecases;

import com.bank.accounts.bankaccounts.data.customer.CustomerRepository;
import com.bank.accounts.bankaccounts.data.customer.CustomerUpdateDto;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomer {

    @Autowired
    private CustomerRepository repository;

    public Customer handle(CustomerUpdateDto customerUpdateDto) {
        Customer customer = new Customer(customerUpdateDto);
        var response = repository.update(customerUpdateDto.id(), customer);
        return response.get();
    }

}
