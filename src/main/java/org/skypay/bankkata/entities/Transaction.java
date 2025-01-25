package org.skypay.bankkata.entities;

import org.skypay.bankkata.enums.TransactionType;

public  class Transaction {
    private final TransactionType type;
    private final int amount;
    private final int balanceAfter;
    private final String date;

    public Transaction(TransactionType type, int amount, int balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.date = java.time.LocalDate.now().toString(); // Get current date
    }

    public int getAmount() {
        return amount;
    }

    public int getBalanceAfter() {
        return balanceAfter;
    }

    public String getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }
}
