package com.bank.accounts.bankaccounts.data.payment;

public record PaymentDto(

        String senderAccountId,
        String destinationAccountId,
        Float paymentValue
) {
}
