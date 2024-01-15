package com.bank.accounts.bankaccounts.domain.payment;

import com.bank.accounts.bankaccounts.data.payment.PaymentDto;

public interface IPaymentRepository {

    public void sendPayment(PaymentDto requestPayment);

    public void addBalance(Float addValue, String destinationAccountId);

    public void removeBalance(Float removeValue, String destinationAccountId);

    public boolean sendNotification(String paymentId);
}
