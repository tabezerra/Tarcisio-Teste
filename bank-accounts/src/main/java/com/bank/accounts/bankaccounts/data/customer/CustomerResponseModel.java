package com.bank.accounts.bankaccounts.data.customer;


import com.bank.accounts.bankaccounts.domain.customer.Customer;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponseModel {

    private String id;
    private String name;
    private String typeAccount;
    private String cpfCnpj;
    private String address;

    private String password;

    public CustomerResponseModel(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.cpfCnpj = customer.getCpfCnpj();
        this.typeAccount = customer.getTypeAccount();
        this.password = customer.getPassword();
    }

}
