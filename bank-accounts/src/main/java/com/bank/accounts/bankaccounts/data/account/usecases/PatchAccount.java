package com.bank.accounts.bankaccounts.data.account.usecases;

import com.bank.accounts.bankaccounts.data.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PatchAccount {

    @Autowired
    AccountRepository accountRepository;

    public void handle(String id, Map<String, Object> fields) {
        accountRepository.patch(id, fields);
    }

}
