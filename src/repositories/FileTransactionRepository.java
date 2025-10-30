package repositories;

import models.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileTransactionRepository implements ITransactionRepository {

    public FileTransactionRepository() {
        File saveFolder = new File("save");
        if (!saveFolder.exists()) {
            saveFolder.mkdir();
        }
    }

    @Override
    public void saveTransactions(List<Transaction> transactions) throws IOException {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to save.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename to save transactions:");
        String fileName = scanner.nextLine().trim();

        File file = new File(new File("save"), fileName + ".txt");
        if (file.exists()) {
            System.out.println("File already exists. Choose a different name.");
            return;
        }

        try (FileWriter writer = new FileWriter(file)) {
            for (Transaction t : transactions) {
                writer.write(t.getAmount() + "," + t.getDate() + System.lineSeparator());
            }
        }

        System.out.println("Transactions saved successfully to " + file.getName());
    }

    @Override
    public List<Transaction> loadTransactions() throws FileNotFoundException {
        File dir = new File("save");
        File[] files = dir.listFiles();
        Scanner scanner = new Scanner(System.in);

        if (files == null || files.length == 0) {
            System.out.println("No save files found.");
            return new ArrayList<>();
        }

        System.out.println("Available save files:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }

        System.out.println("Enter the number of the file to load:");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        File chosenFile = files[choice - 1];

        List<Transaction> transactions = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(chosenFile)) {
            int lineNumber = 0;
            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    System.out.println("Skipping corrupted line " + lineNumber + ": " + line);
                    continue;
                }
                double amount = Double.parseDouble(parts[0]);
                LocalDate date = LocalDate.parse(parts[1].trim());
                transactions.add(new Transaction(amount, date, amount >= 0));
            }
        }
        System.out.println("Loaded " + transactions.size() + " transactions.");
        return transactions;
    }
}
