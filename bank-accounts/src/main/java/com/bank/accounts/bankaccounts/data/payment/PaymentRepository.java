package com.bank.accounts.bankaccounts.data.payment;

import com.bank.accounts.bankaccounts.data.notify.NotifyResponse;
import com.bank.accounts.bankaccounts.core.exeptions.*;
import com.bank.accounts.bankaccounts.domain.account.Account;
import com.bank.accounts.bankaccounts.domain.payment.IPaymentRepository;
import com.bank.accounts.bankaccounts.domain.payment.Payment;
import com.bank.accounts.bankaccounts.domain.repositories.JpaAccountRepository;
import com.bank.accounts.bankaccounts.domain.repositories.JpaPaymentRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PaymentRepository implements IPaymentRepository {

    @Autowired
    JpaPaymentRepository paymentRepository;

    @Autowired
    JpaAccountRepository accountRepository;

    @Value("${url.notify.mock}")
    private String URL_NOTIFY_MOCK;

    Logger log = LoggerFactory.getLogger(PaymentRepository.class);


    @Override
    @Transactional
    public void sendPayment(PaymentDto requestPayment) {
        Optional<Account> senderAccount = accountRepository.findById(requestPayment.senderAccountId());
        if(!senderAccount.isPresent()) {
            throw new AccountNotFoundException("Sender account not found");
        }

        Optional<Account> destinationAccount = accountRepository.findById(requestPayment.destinationAccountId());
        if(!destinationAccount.isPresent()) {
            throw new AccountNotFoundException("Destination account not found");
        }

        if(!senderAccount.get().getState().equals("Active") || !destinationAccount.get().getState().equals("Active")) {
            throw new PaymentAccountInactivatedException();
        }

        if(senderAccount.get().getId().equals(destinationAccount.get().getId())) {
            throw new PaymentAccountDuplicatedException();
        }

        if(senderAccount.get().getBalance() < 0 || senderAccount.get().getBalance() == 0) {
            throw new PaymentAccountBalanceException();
        }

        removeBalance(requestPayment.paymentValue(), requestPayment.senderAccountId());
        addBalance(requestPayment.paymentValue(), requestPayment.destinationAccountId());

        Payment payment = new Payment(requestPayment);
        Payment paymentSave = paymentRepository.save(payment);

        sendNotification(paymentSave.getId());
    }



    @Override
    public void addBalance(Float addValue, String destinationAccountId) {
        Optional<Account> destinationAccount = accountRepository.findById(destinationAccountId);
        if(!destinationAccount.isPresent()) {
            throw new AccountNotFoundException("Destination account not found");
        }

        var oldBalance = destinationAccount.get().getBalance();
        destinationAccount.get().setBalance(oldBalance + addValue);

        accountRepository.save(destinationAccount.get());
    }

    @Override
    public void removeBalance(Float removeValue, String senderAccountId) {
        Optional<Account> senderAccount = accountRepository.findById(senderAccountId);
        if(!senderAccount.isPresent()) {
            throw new AccountNotFoundException("Sender account not found.");
        }

        var oldBalance = senderAccount.get().getBalance();
        if(oldBalance < removeValue) {
            throw new PaymentAccountBalanceException("Sender account balance is less than the amount sent.");
        }
        senderAccount.get().setBalance(oldBalance - removeValue);
        accountRepository.save(senderAccount.get());
    }

    @Override
    public boolean sendNotification(String paymentId) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<NotifyResponse> response = restTemplate.getForEntity(URL_NOTIFY_MOCK, NotifyResponse.class);

            Optional<Payment> currentPayment = paymentRepository.findById(paymentId);
            if(!currentPayment.isPresent()) {
                throw new PaymentNotFoundException();
            }
            if(response.getBody().messageSent() == true) {
                currentPayment.get().setNoticated(true);
                paymentRepository.save(currentPayment.get());
                return true;
            }

            return false;
        } catch (RestClientException restClientException) {
            log.error(restClientException.getMessage());
            throw new NotifyRestClientException();
        }
    }


}
