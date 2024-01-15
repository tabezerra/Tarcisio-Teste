package com.bank.accounts.bankaccounts.data.customer.usecases;

import com.bank.accounts.bankaccounts.data.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PatchCustomer {

    @Autowired
    private CustomerRepository repository;

    public void handle(String id, Map<String, Object> fields) {
        repository.patch(id, fields);
    }
}
