package com.bank.accounts.bankaccounts.core.config;

import com.bank.accounts.bankaccounts.core.exeptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<RestErrorMessage> customerNotFoundHandler(CustomerNotFoundException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorMessage);
    }

    @ExceptionHandler(CustomerAgencyExistsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ResponseEntity<RestErrorMessage> customerAgencyExistsException(CustomerAgencyExistsException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.UNAUTHORIZED,exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseErrorMessage);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<RestErrorMessage> accountNotFoundException(AccountNotFoundException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorMessage);
    }

    @ExceptionHandler(CpfCnpjIsUsedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ResponseEntity<RestErrorMessage> customerAgencyExistsException(CpfCnpjIsUsedException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.UNAUTHORIZED,exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseErrorMessage);
    }

    @ExceptionHandler(PaymentAccountInactivatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ResponseEntity<RestErrorMessage> paymentAccountInactivatedException(PaymentAccountInactivatedException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.UNAUTHORIZED,exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseErrorMessage);
    }

    @ExceptionHandler(PaymentAccountBalanceException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ResponseEntity<RestErrorMessage> paymentAccountBalanceException(PaymentAccountBalanceException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.UNAUTHORIZED,exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseErrorMessage);
    }

    @ExceptionHandler(PaymentAccountDuplicatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ResponseEntity<RestErrorMessage> paymentAccountDuplicatedException(PaymentAccountDuplicatedException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.UNAUTHORIZED,exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseErrorMessage);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<RestErrorMessage> paymentNotFoundException(PaymentNotFoundException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorMessage);
    }

    @ExceptionHandler(NotifyRestClientException.class)
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    private ResponseEntity<RestErrorMessage> notifyRestClientException(NotifyRestClientException exception) {
        RestErrorMessage responseErrorMessage = new RestErrorMessage(HttpStatus.GATEWAY_TIMEOUT,exception.getMessage());
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(responseErrorMessage);
    }

}
