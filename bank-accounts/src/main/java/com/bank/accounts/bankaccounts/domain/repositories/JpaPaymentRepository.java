package com.bank.accounts.bankaccounts.domain.repositories;

import com.bank.accounts.bankaccounts.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPaymentRepository  extends JpaRepository<Payment, String> {
}
