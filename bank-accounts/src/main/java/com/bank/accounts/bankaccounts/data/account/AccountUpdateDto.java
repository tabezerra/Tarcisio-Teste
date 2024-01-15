package com.bank.accounts.bankaccounts.data.account;

import java.util.Date;

public record AccountUpdateDto(
         String id,
         String customerId,
         String agency,
         String balance,
         String state
) {
}
