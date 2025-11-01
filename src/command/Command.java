package command;

import models.Transaction;
import utility.DoubleFormatHelper;
import utility.ScannerHelper;

import java.util.Scanner;

public abstract class Command {
    private static int nextId = 1;
    protected final String name;
    protected final String description;
    private final int idNumber;
    Scanner scanner = ScannerHelper.getScanner();

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
        this.idNumber = nextId++;
    }

    public abstract void execute();

    public void backToMenu() {
        System.out.print("Going back to menu");
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(600); // wait 0.6 second between dots
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // good practice according to googled materials
        }
        System.out.println();
        System.out.println();// move to new line after dots
    }

    protected void printTransactionSummary() {
        System.out.println("-----------------------------");
        System.out.println("Transaction log:");
        for (Transaction t : service.TransactionService.transactions) {
            System.out.println("Amount: " + DoubleFormatHelper.formatDouble(t.getAmount()) + " *** Date: " + t.getDate());
        }
        System.out.println("-----------------------------");
        System.out.println("Total Balance: " + DoubleFormatHelper.formatDouble(service.TransactionService.getCurrentBalance()));
        System.out.println("-----------------------------");
    }

    //Never used so far
    public String getName() {
        return name;
    }

    //Never used so far
    public String getDescription() {
        return description;
    }

    public int getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return idNumber + ". " + name + " - " + description;
    }

}
