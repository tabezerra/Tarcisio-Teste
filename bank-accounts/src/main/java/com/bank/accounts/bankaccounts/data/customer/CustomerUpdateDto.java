package com.bank.accounts.bankaccounts.data.customer;

import jakarta.validation.constraints.NotBlank;

public record CustomerUpdateDto(

        @NotBlank(message = "Por favor, Informe id do Cliente.")
        String id,

        @NotBlank(message = "Por favor, Informe o nome do Cliente.")
        String name,

        String typeAccount,

        String cpfCnpj,

        String address,

        String password)
{}