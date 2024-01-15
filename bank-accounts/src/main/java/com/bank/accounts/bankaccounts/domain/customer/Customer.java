package com.bank.accounts.bankaccounts.domain.customer;


import com.bank.accounts.bankaccounts.data.customer.CustomerDto;
import com.bank.accounts.bankaccounts.data.customer.CustomerUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String name;

	@Column(name = "type_account")
	private String typeAccount;

	@Column(name = "cpf_cnpj", unique = true)
	private String cpfCnpj;

	private String address;

	private String password;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;

	public Customer(CustomerDto customerDto) {
		this.name = customerDto.name();
		this.typeAccount = customerDto.typeAccount();
		this.address = customerDto.address();
		this.cpfCnpj = customerDto.cpfCnpj();
		this.password = customerDto.password();
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Customer(CustomerUpdateDto updateDto) {
		this.name = updateDto.name();
		this.typeAccount = updateDto.typeAccount();
		this.address = updateDto.address();
		this.cpfCnpj = updateDto.cpfCnpj();
		this.password = updateDto.password();
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

}
