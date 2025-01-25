package org.skypay.bankkata.services;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
