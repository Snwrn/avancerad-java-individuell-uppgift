package command;


import models.Transaction;
import utility.DoubleFormatHelper;

import java.util.Scanner;

public class AddTransaction extends Command {

    public AddTransaction() {
        super("Add a new transaction", "Add a new deposit or withdrawal.");
    }

    @Override
    public void execute() {

        System.out.println("1. Deposit (add money to the account)");
        System.out.println("2. Withdrawal (remove money from the account)");
        Scanner scanner = utility.ScannerHelper.getScanner();
        int userChoice = getTransactionType(scanner);
        if (userChoice == 1) {
            handleDeposit(scanner);
        } else if (userChoice == 2) {
            handleWithdrawal(scanner);
        }
        printSummary();
        backToMenu();
    }

    private int getTransactionType(Scanner scanner) {
        while (true) {
            System.out.print("Choose transaction type (1 or 2): ");
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid choice. Please type 1 or 2.");
        }
    }

    private void handleDeposit(Scanner scanner) {
        System.out.print("Write how much is added to your account:");
        double amount = utility.InputHelper.getValidAmount(scanner);
        //if (amount == -1) return;

        double newBalance = service.TransactionService.getCurrentBalance() + amount;
        if (newBalance > utility.InputHelper.MAX_AMOUNT) {
            System.out.println("You have reached the maximum balance limit.");
            return;
        }
        service.TransactionService.addTransaction(amount, true);
    }

    private void handleWithdrawal(Scanner scanner) {
        System.out.print("Write how much is withdrawn from your account:");
        double amount = utility.InputHelper.getValidAmount(scanner);
   //     if (amount == -1) return;

        if (amount > service.TransactionService.getCurrentBalance()) {
            System.out.println("Not enough balance. Transaction canceled.");
            return;
        }

        service.TransactionService.addTransaction(-amount, false);
    }


    /**
     * Adds transaction to list and prints updated info.
     */

    private void printSummary() {
        System.out.println("-----------------------------");
        System.out.println("Transaction log:");
        for (Transaction t : service.TransactionService.transactions) {
            System.out.println("Amount: " + DoubleFormatHelper.formatDouble(t.getAmount())
                    + " *** Date: " + t.getDate());
        }
        System.out.println("-----------------------------");
        System.out.println("Total Balance: " + service.TransactionService.getCurrentBalance());
    }
}
