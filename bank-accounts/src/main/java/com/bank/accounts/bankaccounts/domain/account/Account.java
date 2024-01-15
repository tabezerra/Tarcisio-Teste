package com.bank.accounts.bankaccounts.domain.account;


import com.bank.accounts.bankaccounts.data.account.AccountDto;
import com.bank.accounts.bankaccounts.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@NoArgsConstructor
@Data
@Entity(name = "account")
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @Column(unique = true)
    private String agency;

    private Float balance;

    private String state;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;


    public Account(AccountDto newAccount, Customer customer) {
        this.customer = customer;
        this.agency = newAccount.agency();
        this.balance = newAccount.balance();
        this.state = newAccount.state();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

}
