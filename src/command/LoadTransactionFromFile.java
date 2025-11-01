package command;

import models.Transaction;
import service.TransactionService;

import java.io.IOException;
import java.util.List;

public class LoadTransactionFromFile extends Command {

    public LoadTransactionFromFile() {
        super("Load transactions", "Load transaction history from a file.");
    }

    @Override
    public void execute() {
        try {
            List<Transaction> loaded = TransactionService.repository.loadTransactions();

            if (loaded.isEmpty()) {
                System.out.println("No transactions were loaded.");
            } else {
                service.TransactionService.transactions.clear();
                service.TransactionService.transactions.addAll(loaded);
                System.out.println("Transactions successfully loaded!");
                System.out.println("Loaded transactions:");
                for (Transaction t : loaded) {
                    System.out.println("Amount: " + t.getFormattedAmount() + " | Date: " + t.getDate());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read from file. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error while loading transactions: " + e.getMessage());
        }

        backToMenu();
    }

}
