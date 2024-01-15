package com.bank.accounts.bankaccounts.core.exeptions;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {super("Account not found.");}

    public AccountNotFoundException(String message) { super(message); }
}
