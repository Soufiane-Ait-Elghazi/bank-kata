package org.skypay.bankkata.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypay.bankkata.entities.Transaction;
import org.skypay.bankkata.enums.TransactionType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.skypay.bankkata.enums.ErrorCode.*;
import static org.skypay.bankkata.enums.ErrorCode.STATEMENT_FORMAT;


class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    /***********************| deposit operation Tests |****************************** */
    @Test
    void depositShouldIncreaseBalance() {
        account.deposit(900);
        account.deposit(90);
        account.deposit(9);
        assertEquals(999,account.getBalance(),"Balance should be 1500 after deposits.");
    }

    @Test
    void depositShouldThrowExceptionForNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        assertEquals(INVALID_AMOUNT.getText(), exception.getMessage());
    }




    /***********************| withdraw operation Tests |*******************************/

    @Test
    void withdrawShouldDecreaseBalance() {
        account.setBalance(1000); // separate concerns inntest and isolate the withdrawal functionality
        account.withdraw(400);
        assertEquals(600, account.getBalance(), "Balance should be 600 after withdrawing 400.");
    }

    @Test
    void withdrawShouldThrowExceptionIfInsufficientFunds() {
        account.setBalance(500); // separate concerns inntest and isolate the withdrawal functionality
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(600));
        assertEquals(INSUFFICIENT_FUNDS.getText(), exception.getMessage());
    }

    @Test
    void withdrawShouldThrowExceptionForNegativeAmount() {
        account.setBalance(1000); // separate concerns inntest and isolate the withdrawal functionality
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
        assertEquals(INVALID_AMOUNT.getText(), exception.getMessage());
    }




    /***********************| printStatement operation Tests |*******************************/

    @Test
    void printStatementShouldPrintCorrectTransactionDetails() {

        List<Transaction> transactions = new ArrayList<>();  // separate concerns inntest and isolate the print functionality
        // Prepare account with some transactions
        transactions.add(new Transaction(TransactionType.DEPOSIT,1000,1000));
        transactions.add(new Transaction(TransactionType.WITHDRAW,500,500));
        transactions.add(new Transaction(TransactionType.DEPOSIT,33,533));
        account.setTransactions(transactions);

        // create the expected
        StringBuffer expectedstatementBuffer = new StringBuffer();
        expectedstatementBuffer.append(PRINT_STATEMENT_HEADER.getText()).append("\n");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            String formattedAmount = transaction.getType().equals(TransactionType.WITHDRAW)
                    ? "-" + transaction.getAmount()
                    : String.valueOf(transaction.getAmount());

            expectedstatementBuffer.append(String.format(STATEMENT_FORMAT.getText(),
                            transaction.getDate(),
                            formattedAmount,
                            transaction.getBalanceAfter()))
                    .append("\n");
        }

        // Call printStatement to capture the output
        account.printStatement();
        System.out.println(account.getStatementBuffer().toString());

        assertEquals(expectedstatementBuffer.toString(), account.getStatementBuffer().toString(),
                "The printed statement should match the expected format and content.");


    }







}
