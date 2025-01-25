package org.skypay.bankkata.services;

import org.skypay.bankkata.entities.Transaction;
import org.skypay.bankkata.enums.TransactionType;

import java.util.ArrayList;
import java.util.List;

import static org.skypay.bankkata.enums.ErrorCode.*;
import static org.skypay.bankkata.enums.ErrorCode.STATEMENT_FORMAT;

public class Account implements AccountService {
    private int balance = 0;
    StringBuffer statementBuffer ;
    private final List<Transaction> transactions = new ArrayList<>();

    public int getBalance() {
        return balance;
    }

    public StringBuffer getStatementBuffer() {
        return statementBuffer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getText());
        }
        balance += amount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getText());
        }
        if (amount > balance) {
            throw new IllegalArgumentException(INSUFFICIENT_FUNDS.getText());
        }
        balance -= amount;
        transactions.add(new Transaction(TransactionType.WITHDRAW, amount, balance));
    }

    @Override
    public void printStatement() {
        StringBuffer statementBuffer = new StringBuffer();
        statementBuffer.append(PRINT_STATEMENT_HEADER.getText()).append("\n");
        for (Transaction transaction : transactions) {
            String formattedAmount = transaction.getType().equals(TransactionType.WITHDRAW)
                    ? "-" + transaction.getAmount()
                    : String.valueOf(transaction.getAmount());

            statementBuffer.append(String.format(STATEMENT_FORMAT.getText(),
                            transaction.getDate(),
                            formattedAmount,
                            transaction.getBalanceAfter()))
                    .append("\n");
        }
        this.statementBuffer = statementBuffer;
        System.out.println(statementBuffer.toString());
    }




}
