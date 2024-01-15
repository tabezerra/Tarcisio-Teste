package com.bank.accounts.bankaccounts.core.exeptions;

public class CpfCnpjIsUsedException extends RuntimeException {

    public CpfCnpjIsUsedException() {super("CpfCnpj is used.");}

    public CpfCnpjIsUsedException(String message) { super(message); }

}
