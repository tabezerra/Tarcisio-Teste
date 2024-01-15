package com.bank.accounts.bankaccounts.domain.account;

import com.bank.accounts.bankaccounts.data.account.AccountDto;
import com.bank.accounts.bankaccounts.data.account.AccountResponseModel;
import com.bank.accounts.bankaccounts.data.account.AccountUpdateDto;
import com.bank.accounts.bankaccounts.domain.customer.Customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IAccountRepository {

    Optional<Account> create(AccountDto newAccount);

    boolean checkCustomerAndAgencyExists(Customer customer, String agency);

    void delete(String accountId);

    Optional<Account> getAccountById(String accountId);

    List<AccountResponseModel> getAllAnyAccount();

    Optional<Account> patch(String id, Map<String, Object> fields);

    void update(AccountUpdateDto updateAccount);

}
