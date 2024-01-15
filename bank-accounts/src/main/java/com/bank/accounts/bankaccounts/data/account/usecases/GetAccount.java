package com.bank.accounts.bankaccounts.data.account.usecases;

import com.bank.accounts.bankaccounts.data.account.AccountRepository;
import com.bank.accounts.bankaccounts.data.account.AccountResponseModel;
import com.bank.accounts.bankaccounts.core.exeptions.AccountNotFoundException;
import com.bank.accounts.bankaccounts.domain.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAccount {

    @Autowired
    AccountRepository accountRepository;

    public Optional<AccountResponseModel> handle(String id) {

        Optional<Account> account = accountRepository.getAccountById(id);
        if(!account.isPresent()) {
            throw new AccountNotFoundException();
        }
        AccountResponseModel responseModel = new AccountResponseModel(account.get());
        return Optional.of(responseModel);
    }
}
