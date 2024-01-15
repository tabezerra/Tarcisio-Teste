package com.bank.accounts.bankaccounts.data.payment.usecases;

import com.bank.accounts.bankaccounts.data.payment.PaymentDto;
import com.bank.accounts.bankaccounts.data.payment.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePayment {

    @Autowired
    PaymentRepository paymentRepository;

    public void handle(PaymentDto requestDto) {
        paymentRepository.sendPayment(requestDto);
    }
}
