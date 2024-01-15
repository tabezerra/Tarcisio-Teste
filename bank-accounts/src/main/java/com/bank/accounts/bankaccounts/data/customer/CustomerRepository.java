package com.bank.accounts.bankaccounts.data.customer;

import com.bank.accounts.bankaccounts.core.exeptions.CpfCnpjIsUsedException;
import com.bank.accounts.bankaccounts.core.exeptions.CustomerNotFoundException;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import com.bank.accounts.bankaccounts.domain.repositories.JpaCustomerRepository;
import com.bank.accounts.bankaccounts.domain.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerRepository implements ICustomerRepository {

    @Autowired
    final JpaCustomerRepository jpaCustomRepository;

    public CustomerRepository(JpaCustomerRepository jpaCustomRepository) {
        this.jpaCustomRepository = jpaCustomRepository;
    }

    @Override
    public Customer create(Customer customer) {
        var checkCpfCnpj = jpaCustomRepository.existsByCpfCnpj(customer.getCpfCnpj());
        if(checkCpfCnpj) {
            throw new CpfCnpjIsUsedException();
        }

        Customer newCustomer = jpaCustomRepository.save(customer);
        return newCustomer;
    }

    @Override
    public Optional<Customer> get(String id) {
        var customer = jpaCustomRepository.findById(id);
        if(!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        return Optional.of(customer.get());
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> list = jpaCustomRepository.findAll();
        return list;
    }


    @Override
    public Optional<Customer> update(String id, Customer updateCustomer) {
        var oldCustomer = jpaCustomRepository.findById(id);
        if(oldCustomer.isPresent()) {
            Customer customer = oldCustomer.get();
            customer.setName(updateCustomer.getName());
            customer.setAddress(updateCustomer.getAddress());
            customer.setCpfCnpj(updateCustomer.getCpfCnpj());
            customer.setPassword(updateCustomer.getPassword());
            customer.setTypeAccount(updateCustomer.getTypeAccount());
            customer.setUpdatedAt(new Date());

            Customer updatedCustomer = jpaCustomRepository.save(customer);

            return Optional.of(updatedCustomer);
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        try {
            jpaCustomRepository.deleteById(id);
        } catch (IllegalArgumentException exception) {

        }
    }

    @Override
    public Optional<Customer> patch(String id, Map<String, Object> fields) {
        Optional<Customer> existingCustomer = jpaCustomRepository.findById(id);

        if(!existingCustomer.isPresent()) {
            System.out.println("Id nao encontrado");
            return Optional.empty();
        }

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Customer.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingCustomer.get(), value);
        });

        Customer patchCustomer = jpaCustomRepository.save(existingCustomer.get());
        return Optional.of(patchCustomer);
    }

}
