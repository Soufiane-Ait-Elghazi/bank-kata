package org.skypay.bankkata.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypay.bankkata.entities.Transaction;
import org.skypay.bankkata.enums.TransactionType;

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
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance(), "Balance should be 600 after withdrawing 400.");
    }

    @Test
    void withdrawShouldThrowExceptionIfInsufficientFunds() {
        account.deposit(500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(600));
        assertEquals(INSUFFICIENT_FUNDS.getText(), exception.getMessage());
    }

    @Test
    void withdrawShouldThrowExceptionForNegativeAmount() {
        account.deposit(1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
        assertEquals(INVALID_AMOUNT.getText(), exception.getMessage());
    }




    /***********************| printStatement operation Tests |*******************************/

    @Test
    void printStatementShouldPrintCorrectTransactionDetails() {

        // Prepare account with some transactions
        account.deposit(1000); // Deposit 1000
        account.withdraw(500); // Withdraw 500
        account.deposit(1000); // Deposit 1000
        account.deposit(1000); // Deposit 1000
        account.withdraw(500); // Withdraw 500
        account.withdraw(500); // Withdraw 500
        // create the expected

        StringBuffer expectedstatementBuffer = new StringBuffer();
        expectedstatementBuffer.append(PRINT_STATEMENT_HEADER.getText()).append("\n");
        for (Transaction transaction : account.getTransactions()) {
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
