package com.bank.accounts.bankaccounts.core.exeptions;

public class PaymentAccountDuplicatedException extends RuntimeException{

    public PaymentAccountDuplicatedException() {super("Payment Account duplicated.");}

    public PaymentAccountDuplicatedException(String message) { super(message); }
}
