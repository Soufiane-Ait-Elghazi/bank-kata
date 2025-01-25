package org.skypay.bankkata;

import org.skypay.bankkata.services.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class BankKataApplication {

    public static void main(String[] args) {

       // SpringApplication.run(BankKataApplication.class, args);

        Account myAccount = new Account();
        //myAccount.deposit(1000);//deposit method not implemented yet.
        //myAccount.withdraw(200);//withdraw method not implemented yet.
        //myAccount.deposit(500);//deposit method not implemented yet.
        //myAccount.printStatement(); //printStatement method not implemented yet.
    }

}
