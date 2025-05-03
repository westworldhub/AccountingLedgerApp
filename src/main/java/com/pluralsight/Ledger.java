package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;


public  class Ledger {
    // Static list to hold all transactions in memory
    private static List <Transaction> transactions;
    // File path to the CSV file where transactions are stored
    private static final String FILE_PATH = "/Users/abdulkadiryanar/Desktop/Pluralsight/Workbook-3/AccountingLedgerApp/src/main/resources/data/transactions.csv";
    //Constructor to initialize the Ledger with a list of transactions.
    public Ledger(List<Transaction> transactions) {
        this.transactions=transactions;
    }

    //Adds a deposit transaction to the ledger.
    public static void addDeposit(String decription, String vendor, double amount){
        Transaction deposit = new Transaction(LocalDate.now(), LocalTime.now(),decription,vendor,amount);
        transactions.add(deposit);

        //save it to the csv file with method
        TransactionHelper.saveTransaction(deposit,FILE_PATH);
        System.out.println("Deposit added");
    }

    //Adds a payment transaction to the ledger.
    public static void makePayment(String description,String vendor, double amount){
        Transaction payment =new Transaction(LocalDate.now(),LocalTime.now(),description,vendor,-Math.abs(amount));
        transactions.add(payment);
        TransactionHelper.saveTransaction(payment,FILE_PATH);
        System.out.println("Payment added");
    }
    // Display All transaction starting from the most recent.
    public static void displayAll () {
        for(int i = transactions.size()-1; i>=0; i--) {
            System.out.println(transactions.get(i));
        }
    }

    // Displays only the deposit transactions (positive amounts).
    public static void displayDeposit(){
        for(int i = transactions.size()-1; i >=0; i--){
            Transaction t = transactions.get(i);
            if (t.getAmount()>=0){
                System.out.println(t);
            }
        }
    }

    //Displays only the payment transactions (negative amounts).
    public static void displayPayment(){
        for(int i = transactions.size()-1; i>=0; i--){
            Transaction t = transactions.get(i);
            if(t.getAmount()<=0){
                System.out.println(t);
            }
        }

    }
    //Shows the Ledger menu and handles user input to navigate ledger options.
    public static void ledgerMenu(Scanner read){


        boolean ledger=true;
        while(ledger){
            System.out.println("\n--- Ledger Menu ---\n");
            System.out.println("A) Display All");
            System.out.println("D) Display Deposits");
            System.out.println("P) Display Payments");
            System.out.println("R) Display Reports Menu");
            System.out.println("H) Home");
            System.out.print("Select: \n");
            String choice = read.nextLine().trim().toUpperCase();

            switch (choice){
                case "A" :
                    displayAll( );
                    break;
                case "D" :
                    displayDeposit();
                    break;
                case "P" :
                    displayPayment();
                    break;
                case "R" :
                    Reports.reportsMenu(read);
                case "H" :
                    ledger=false; //Exit loop to return to Home
                    break;
                default:
                    System.out.println("invalid choice");
            }
        }
    }

}