package org.skypay.bankkata.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    /***********************| deposit operation Tests |****************************** */
    @Test
    void depositShouldIncreaseBalance() {
        //TO DO
    }

    @Test
    void depositShouldThrowExceptionForNegativeAmount() {
        //TO DO
    }




    /***********************| withdraw operation Tests |*******************************/

    @Test
    void withdrawShouldDecreaseBalance() {
        //TO DO
    }

    @Test
    void withdrawShouldThrowExceptionIfInsufficientFunds() {
      //TO DO
    }

    @Test
    void withdrawShouldThrowExceptionForNegativeAmount() {
         //TO DO
    }




    /***********************| printStatement operation Tests |*******************************/

    @Test
    void printStatementShouldPrintCorrectTransactionDetails() {
        //TO DO
    }



}
