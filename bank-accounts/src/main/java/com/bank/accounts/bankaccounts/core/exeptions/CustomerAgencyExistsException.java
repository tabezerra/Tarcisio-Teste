package com.bank.accounts.bankaccounts.core.exeptions;

public class CustomerAgencyExistsException extends RuntimeException {

    public CustomerAgencyExistsException() {super("Customer and Agency is used.");}

    public CustomerAgencyExistsException(String message) { super(message); }
}
