package com.bank.accounts.bankaccounts.data.account;


import com.bank.accounts.bankaccounts.domain.customer.Customer;
import jakarta.validation.constraints.NotBlank;

public record AccountDto(
        @NotBlank
        String customerId,
        @NotBlank
        String agency,
        Float balance,
        String state)
{}
