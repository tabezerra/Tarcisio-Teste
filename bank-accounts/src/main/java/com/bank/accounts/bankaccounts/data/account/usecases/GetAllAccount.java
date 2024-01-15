package com.bank.accounts.bankaccounts.data.account.usecases;

import com.bank.accounts.bankaccounts.data.account.AccountRepository;
import com.bank.accounts.bankaccounts.data.account.AccountResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAccount {

    @Autowired
    AccountRepository accountRepository;


    public List<AccountResponseModel> handle() {
       return accountRepository.getAllAnyAccount();
    }
}
