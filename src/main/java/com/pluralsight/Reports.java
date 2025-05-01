package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class Reports {
    private static List<Transaction> transactions;

    public Reports(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void reportsMenu(Scanner read){

        String choice;
        do{
            System.out.println("\n--- Reports ---\n");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Select: ");
            choice = read.nextLine().trim();

            switch (choice){
                case "1":
                    //displayMonthToDate();
                    break;
                case "2":
                    //displayPreviousMonth();
                    break;
                case "3":
                    //displayYearToDate()
                    break;
                case "4":
                    //displayPreviousYear();
                    break;
                case "5":
                    //displayPreviousYear();
                    break;
            }

        }while (!choice.equals("0"));

    }
}
