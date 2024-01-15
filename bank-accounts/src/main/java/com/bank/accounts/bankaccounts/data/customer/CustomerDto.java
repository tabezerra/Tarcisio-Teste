package com.bank.accounts.bankaccounts.data.customer;

import jakarta.validation.constraints.NotBlank;

public record CustomerDto(

		@NotBlank(message = "Por favor, Informe o nome do Cliente.")
		String name,
		String typeAccount,
		String cpfCnpj,
		String address,
		String password)
{}
