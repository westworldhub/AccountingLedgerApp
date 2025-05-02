package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Transaction> transactions = TransactionHelper.readTransactions("/Users/abdulkadiryanar/Desktop/Pluralsight/Workbook-3/AccountingLedgerApp/src/main/resources/data/transactions.csv");
        new Ledger(transactions);
        new Reports(transactions);
        Scanner read = new Scanner(System.in);
        String choice;

        boolean running=true;
        while (running){
            System.out.println("\n Welcome to Accounting Ledger App ");

            System.out.println("\n--- Home Menu ---");
            System.out.println("(D) Add Deposit: ");
            System.out.println("(P) Make Payment(Debit): ");
            System.out.println("(L) Ledger: ");
            System.out.println("(X) Exit: ");
            System.out.println("Chose an option: ");
            choice = read.nextLine().trim().toUpperCase();

            switch (choice) {
                case "D":
                    //prompt user for the deposit information
                    System.out.println("Please enter deposit description: ");
                    String depositDescription = read.nextLine();
                    System.out.println("Please enter vendor: ");
                    String depositVendor = read.nextLine();
                    System.out.println("Please enter amount");
                    double depositAmount = Double.parseDouble(read.nextLine());
                    Ledger.addDeposit(depositDescription,depositVendor,depositAmount);
                    break;
                case "P":
                    // prompt user for the debit
                    System.out.println("Please enter deposit description: ");
                    String paymentDescription = read.nextLine();
                    System.out.println("Please enter vendor: ");
                    String paymentVendor = read.nextLine();
                    System.out.println("Please enter amount");
                    double paymentAmount = Double.parseDouble(read.nextLine());
                    Ledger.makePayment(paymentDescription,paymentVendor,paymentAmount);
                    //information and save it to the csv file
                    break;
                case "L":
                    Ledger.ledgerMenu(read);
                    break;
                case "X":
                    running=false;
                    System.out.println("Exiting...");
                    //exit the application
                    break;
            }
        }
    }
}
