package com.bank.accounts.bankaccounts.data.customer.usecases;

import com.bank.accounts.bankaccounts.data.customer.CustomerRepository;
import com.bank.accounts.bankaccounts.data.customer.CustomerResponseModel;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllCustomer {

    @Autowired
    private CustomerRepository repository;

    public List<CustomerResponseModel> handle() {
        List<Customer> listCustomer = repository.getAll();
        List<CustomerResponseModel> listResponse = new ArrayList<>();

        listCustomer.forEach((customer) -> {
            listResponse.add(new CustomerResponseModel(customer));
        });



        return listResponse;
    }
}
