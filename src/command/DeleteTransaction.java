package command;


import java.util.Scanner;

public class DeleteTransaction extends Command {
    public DeleteTransaction() {
        super("Delete a transaction", "Remove a transactions from the logs, restore balance.");
    }

    @Override
    public void execute() {

        //Checks if the transaction list has anything to delete
        Scanner scanner = utility.ScannerHelper.getScanner();
        if (!service.TransactionService.transactions.isEmpty()) {
            //Prints out all the transactions that are available to delete.
            System.out.println("Transaction log:");
            for (int i = 0; i < service.TransactionService.transactions.size(); i++) {
                System.out.println(
                        (i + 1)
                                + ". "
                                + service.TransactionService.transactions.get(i).getFormattedAmount()
                                + " *** "
                                + service.TransactionService.transactions.get(i).transactionDate);
            }

            //Initiating variables that are needed
            String userInput;
            int index = -1; //Put to -1 so that the while loop will work as I want
            while (index == -1) {
                System.out.println("Write the number of the transaction you want to delete, or write ¨menu¨ to go back to menu:");
                //getting user input to validate
                userInput = scanner.nextLine().trim();
                if (userInput.equalsIgnoreCase("menu")) {
                    backToMenu();
                    return;
                }
                try {
                    //Try to make it an integer
                    int check = Integer.parseInt(userInput) - 1;
                    //check if the integer within the wanted range
                    if (check >= 0 && check < service.TransactionService.transactions.size()) {
                        index = check; //if success, assign index
                    } else
                        //if not success print error message
                        System.out.println("Invalid transaction number, write a number of transaction from the list.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            // Pick the transaction before removing
            models.Transaction transactionToDelete = service.TransactionService.transactions.get(index);
            double deletedAmount = transactionToDelete.amount; //variable to show how much was deleted
            // Checking if balance goes negative:
            // Step one. Simulate the balance after deletion.
            double simulatedBalance = (service.TransactionService.getCurrentBalance());
            simulatedBalance = simulatedBalance - transactionToDelete.amount;


            // Step two. Check if it goes negative:
            if (simulatedBalance < 0) {
                System.out.println("Cannot delete this transaction — your balance would become negative.");
            } else {
                //if balance does not go negative, allow to delete the transaction.
                service.TransactionService.transactions.remove(index);
                System.out.println("Transaction (amount:" + utility.DoubleFormatHelper.formatDouble(deletedAmount) + ") has been deleted.");
            }
        } else {
            System.out.println("Transaction log is empty, no transactions to delete.");
        }
    }
}
