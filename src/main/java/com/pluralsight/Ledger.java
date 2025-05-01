package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ledger {
    private List <Transaction> transactions;

    public Ledger(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addDeposit(String decription, String vendor, double amount){
        Transaction t = new Transaction(LocalDate.now(), LocalTime.now(),decription,vendor,amount);
        transactions.add(t);
        System.out.println("Deposit added");
    }

    public void makePayment(String description,String vendor, double amount){
        Transaction t =new Transaction(LocalDate.now(),LocalTime.now(),description,vendor,amount);
        transactions.add(t);
        System.out.println("Payment added");
    }
    // Display All transaction
    public  void displayAll () {
        for(int i = transactions.size()-1; i>=0; i--) {
            System.out.println(transactions.get(i));
        }
    }

}
