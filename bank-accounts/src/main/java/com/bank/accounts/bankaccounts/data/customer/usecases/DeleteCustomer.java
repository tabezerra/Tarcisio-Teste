package com.bank.accounts.bankaccounts.data.customer.usecases;

import com.bank.accounts.bankaccounts.data.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomer {

    @Autowired
    private CustomerRepository repository;

    public void handle(String idCustomer) {
        repository.delete(idCustomer);
    }
}
