package service;

import models.Transaction;
import repositories.FileTransactionRepository;
import repositories.ITransactionRepository;
import utility.DoubleFormatHelper;

import java.time.LocalDate;
import java.util.ArrayList;


public class TransactionService {
    public static final ITransactionRepository repository = new FileTransactionRepository();
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static double getCurrentBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public static void addTransaction(double amount, boolean isDeposit) {
        Transaction transaction = new Transaction(amount, LocalDate.now(), isDeposit);
        transactions.add(transaction);
        System.out.println((isDeposit ? "Deposit" : "Withdrawal") + " added: "
                + DoubleFormatHelper.formatDouble(amount));
    }
}
