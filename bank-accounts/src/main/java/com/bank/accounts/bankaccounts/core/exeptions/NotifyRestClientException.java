package com.bank.accounts.bankaccounts.core.exeptions;

public class NotifyRestClientException extends RuntimeException {

    public NotifyRestClientException() {super("Notification currently unavailable.");}

    public NotifyRestClientException(String message) { super(message); }
}
