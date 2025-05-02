package com.pluralsight;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Reports {
    private static List<Transaction> transactions;
    private static LocalDate now = LocalDate.now();

    public Reports(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public static void reportsMenu(Scanner read){

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
                    displayMonthToDate(transactions);
                    break;
                case "2":
                    //displayPreviousMonth();
                    displayPreviousMonth(transactions);
                    break;
                case "3":
                    //displayYearToDate()
                    displayYearToDate(transactions);
                    break;
                case "4":
                    //displayPreviousYear();
                    displayPreviousYear(transactions);
                    break;
                case "5":
                    //Search by Vendor
                    searchByVendor(transactions);
                    break;
            }

        }while (!choice.equals("0"));

    }

    // Displays transactions for the current month.
    public static void displayMonthToDate(List<Transaction> transactions){
        boolean found = false;
        for(int i= transactions.size()-1; i<=0; i --){
        Transaction t = transactions.get(i);
        if(now.getYear()==t.getDate().getYear() && now.getMonth() == t.getDate().getMonth()){
            System.out.println(t);
            found=true;
            }
        }
        if (!found) System.out.println("No transactions found for current month.");
    }

    //Displays transactions for the previous month.
    public static void displayPreviousMonth(List<Transaction> transactions){
        // If the current month is January (1), then the previous month is December (12).
        // Otherwise, subtract 1 from the current month to get the previous month.
        int previousMonth = now.getMonthValue() == 1 ? 12 : now.getMonthValue() - 1;
        // If the current month is January, the previous month belongs to the previous year (year - 1).
        // Otherwise, the year remains the same.
        int year = now.getMonthValue() == 1 ? now.getYear() - 1 : now.getYear();
        boolean found = false;
        for(int i=transactions.size()-1; i>=0; i--){
            Transaction t = transactions.get(i);
            if(year==t.getDate().getYear() && previousMonth == t.getDate().getMonthValue()){
                    System.out.println(t);
            }
        }
    }

    //Displays transactions for the current year
    public  static void displayYearToDate(List<Transaction> transactions){
        int currentYear= now.getYear();
        boolean found = false;
        for (int i = transactions.size()-1; i>0; i--){
            Transaction t = transactions.get(i);
            if(currentYear==t.getDate().getYear()){
                System.out.println(t);
                found=true;
            }
        }
        if (!found) System.out.println("No transactions found for current year.");
    }

    //Displays transactions for the previous year.
    public static void displayPreviousYear(List<Transaction> transactions){
        int previousYear = now.getYear()-1;
        boolean found = false;
       for( int i = transactions.size()-1; i>=0; i--){
           Transaction t = transactions.get(i);
        if (previousYear==t.getDate().getYear()) {
            System.out.println(t);
            found=true;
        }
       }
        if (!found) System.out.println("No transactions found for previous year.");
    }
    //Searches and displays transactions by vendor name.
    public static void searchByVendor(List<Transaction> transactions){

        System.out.println("Enter Vendor name");
        Scanner read = new Scanner(System.in);
        String vendor =read.nextLine().trim();
        boolean found = false;

        for(Transaction t : transactions){
            if(t.getVendor().equalsIgnoreCase(vendor)){
                System.out.println(t);
                found=true;
            }
        }
        if (!found) System.out.println("No transactions found for vendor: " + vendor);
    }
}
