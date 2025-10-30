package command;

import models.Transaction;
import service.TransactionService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveTransactionsToFile extends Command{
    public SaveTransactionsToFile() {
        super("Save transactions", "Save transaction history to a file.");
    }

    @Override
    public void execute() {
        try {
            service.TransactionService.repository.saveTransactions(TransactionService.transactions);
        } catch (Exception e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
        backToMenu();
    }
}
