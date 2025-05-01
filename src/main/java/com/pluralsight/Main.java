package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Welcome to Accounting Ledger Menu \n");
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
                    double depositAmount = read.nextDouble();
                    //and save it to the csv file with method

                    break;
                case "P":
                    // prompt user for the debit
                    System.out.println("Please enter deposit description: ");
                    String paymentDescription = read.nextLine();
                    System.out.println("Please enter vendor: ");
                    String paymentVendor = read.nextLine();
                    System.out.println("Please enter amount");
                    double paymentAmount = read.nextDouble();
                    //information and save it to the csv file
                    break;
                case "L":
                    //display the ledger screen

                    break;
                case "X":
                    //exit the application
                    break;
            }
        } while (!choice.equals("X"));
    }
}
