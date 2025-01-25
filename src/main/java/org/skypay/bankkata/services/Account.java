package org.skypay.bankkata.services;

import org.skypay.bankkata.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService{
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
        throw new UnsupportedOperationException("deposit method not implemented yet.");
    }

    @Override
    public void withdraw(int amount) {
        throw new UnsupportedOperationException("withdraw method not implemented yet.");
    }

    @Override
    public void printStatement() {
        throw new UnsupportedOperationException("printStatement method not implemented yet.");
    }
}
