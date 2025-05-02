package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionHelper {
    //Reads transactions from a CSV file and returns a list of Transaction objects.
    public static List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        File file = new File(filePath);

        // If the CSV file does not exist, notify the user and return an empty list
        if (!file.exists()) {
            System.out.println("transactions.csv not found. Starting with empty list.");
            return transactions;
        }
        //Try to read each line in the file and convert it to a Transaction object
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(Transaction.fromCSV(line)); //Parse and add each transaction
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }
    //Appends a new transaction to the CSV file.
    public static void saveTransaction(Transaction transaction, String filePath) {
        // Try to open the file in append mode and write the new transaction
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(transaction.toCSV());// Convert transaction to CSV format
            writer.newLine(); // Write a new line for the next entry
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
