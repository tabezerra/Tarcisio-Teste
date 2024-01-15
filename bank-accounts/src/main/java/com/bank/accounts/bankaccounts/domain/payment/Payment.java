package com.bank.accounts.bankaccounts.domain.payment;

import com.bank.accounts.bankaccounts.data.payment.PaymentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "payment")
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "sender_account_id")
    private String senderAccountId;

    @Column(name = "destination_account_id")
    private String destinationAccountId;

    @Column(name = "payment_value")
    private Float paymentValue;

    @CreatedDate
    @Column(name = "date_payment")
    private Date datePayment;

    private boolean noticated;

    public Payment(PaymentDto dto) {
        this.senderAccountId = dto.senderAccountId();
        this.destinationAccountId = dto.destinationAccountId();
        this.paymentValue = dto.paymentValue();
        this.datePayment = new Date();
    }

}
