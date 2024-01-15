package com.bank.accounts.bankaccounts.data.account;


import com.bank.accounts.bankaccounts.data.account.usecases.CreateAccount;

import com.bank.accounts.bankaccounts.data.account.usecases.GetAccount;
import com.bank.accounts.bankaccounts.data.account.usecases.GetAllAccount;
import com.bank.accounts.bankaccounts.data.account.usecases.PatchAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    CreateAccount createAccount;

    @Autowired
    GetAccount getAccount;

    @Autowired
    PatchAccount patchAccount;

    @Autowired
    GetAllAccount getAllAccount;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountResponseModel> createAccount(@RequestBody AccountDto requestAccount) {
        AccountResponseModel newAccount = createAccount.handle(requestAccount);
        log.info("POST - account");
        return new ResponseEntity<AccountResponseModel>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountResponseModel>> getAllAccount() {
        log.info("GET ALL - account");
        return new ResponseEntity<List<AccountResponseModel>>(getAllAccount.handle(), HttpStatus.OK);
    }

    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountResponseModel> getAccount(@PathVariable String id) {
        log.info("GET - account");
        return new ResponseEntity<AccountResponseModel>(getAccount.handle(id).get(), HttpStatus.OK);
    }

    @PatchMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity patchAccount(@PathVariable String id, @RequestBody Map<String, Object> fields) {
        patchAccount.handle(id, fields);
        log.info("PATCH - account");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
