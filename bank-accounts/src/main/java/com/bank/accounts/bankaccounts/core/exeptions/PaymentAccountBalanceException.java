package com.bank.accounts.bankaccounts.core.exeptions;

public class PaymentAccountBalanceException extends RuntimeException {

    public PaymentAccountBalanceException() {super("Sender Account balance zero or negative.");}

    public PaymentAccountBalanceException(String message) { super(message); }
}
