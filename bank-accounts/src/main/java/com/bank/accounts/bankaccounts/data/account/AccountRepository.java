package com.bank.accounts.bankaccounts.data.account;

import com.bank.accounts.bankaccounts.core.exeptions.AccountNotFoundException;
import com.bank.accounts.bankaccounts.core.exeptions.CustomerAgencyExistsException;
import com.bank.accounts.bankaccounts.core.exeptions.CustomerNotFoundException;
import com.bank.accounts.bankaccounts.domain.account.Account;
import com.bank.accounts.bankaccounts.domain.account.IAccountRepository;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import com.bank.accounts.bankaccounts.domain.repositories.JpaAccountRepository;
import com.bank.accounts.bankaccounts.domain.repositories.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountRepository implements IAccountRepository {

    @Autowired
    JpaAccountRepository accountRepository;

    @Autowired
    JpaCustomerRepository customerRepository;

    @Override
    public Optional<Account> create(AccountDto newAccount) {
        Optional<Customer> customer = customerRepository.findById(newAccount.customerId());
        if(!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }

        if(checkCustomerAndAgencyExists(
                customer.get(), newAccount.agency())) {
            throw new CustomerAgencyExistsException();
        }

        if(customer.isPresent()) {
            return Optional.of(accountRepository.save(new Account(newAccount, customer.get())));
        }
        return Optional.empty();
    }

    @Override
    public boolean checkCustomerAndAgencyExists(Customer customer, String agency) {
        var accountExists = accountRepository.existsByCustomerAndAgency(customer, agency);
        var agencyExists = accountRepository.existsByAgency(agency);
        if(accountExists || agencyExists) {
            return true;
        }
        return false;
    }

    @Override
    public void delete(String accountId) {

    }

    @Override
    public Optional<Account> getAccountById(String accountId) {
        Optional<Account> account = accountRepository.findById(accountId);

        if(!account.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(account.get());
    }

    @Override
    public List<AccountResponseModel> getAllAnyAccount() {
        List<Account> listAccounts = accountRepository.findAll();
        List<AccountResponseModel> response = new ArrayList<>();

        for (Account account : listAccounts) {
            response.add(new AccountResponseModel(account));
        }
        return response;
    }

    @Override
    public Optional<Account> patch(String id, Map<String, Object> fields) {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()) {
            throw new AccountNotFoundException();
        }
            fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Account.class, key);
            field.setAccessible(true);
            if(key.equals("balance")) {
                ReflectionUtils.setField(field, account.get(), Float.valueOf(value.toString()));
            } else {
                ReflectionUtils.setField(field, account.get(), value);
            }

        });

        Account patchAccount = accountRepository.save(account.get());
        return Optional.of(patchAccount);
    }

    @Override
    public void update(AccountUpdateDto updateAccount) {

    }
}
