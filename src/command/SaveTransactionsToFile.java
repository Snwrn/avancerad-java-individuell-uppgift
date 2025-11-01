package command;

import service.TransactionService;

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
