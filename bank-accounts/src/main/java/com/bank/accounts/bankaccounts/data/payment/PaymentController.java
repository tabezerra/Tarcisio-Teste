package com.bank.accounts.bankaccounts.data.payment;


import com.bank.accounts.bankaccounts.data.account.usecases.CreateAccount;
import com.bank.accounts.bankaccounts.data.payment.usecases.CreatePayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    CreatePayment createPayment;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPayment(@RequestBody PaymentDto request) {
        createPayment.handle(request);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}
