package com.bank.accounts.bankaccounts.data.account;

import com.bank.accounts.bankaccounts.domain.account.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountResponseModel {

    private String id;
    private String customerId;
    private Float balance;

    private String agency;
    private String state;

    public AccountResponseModel(Account account) {
        this.id = account.getId();
        this.customerId = account.getCustomer().getId();
        this.balance = account.getBalance();
        this.agency = account.getAgency();
        this.state = account.getState();
    }

}
