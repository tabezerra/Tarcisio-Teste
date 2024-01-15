package com.bank.accounts.bankaccounts.core.exeptions;

public class PaymentAccountInactivatedException extends RuntimeException {

    public PaymentAccountInactivatedException() {super("Account is inactivated.");}

    public PaymentAccountInactivatedException(String message) { super(message); }
}
