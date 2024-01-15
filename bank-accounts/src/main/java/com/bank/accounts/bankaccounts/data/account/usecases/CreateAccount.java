package com.bank.accounts.bankaccounts.data.account.usecases;

import com.bank.accounts.bankaccounts.data.account.AccountDto;
import com.bank.accounts.bankaccounts.data.account.AccountRepository;
import com.bank.accounts.bankaccounts.data.account.AccountResponseModel;
import com.bank.accounts.bankaccounts.domain.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccount {

    @Autowired
    AccountRepository accountRepository;

    public AccountResponseModel handle(AccountDto request) {
        Account account = accountRepository.create(request).get();
        return new AccountResponseModel(account);
    }

}
