package service;

import models.Transaction;
import repositories.FileTransactionRepository;
import repositories.ITransactionRepository;
import utility.DoubleFormatHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Vi skulle även kunna göra TodoService till ett interface för att
// kunna återanvända den, och göra den mer flexibel, lik CommandService
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
    // Vi kan enkelt byta implementation genom att
    // kommentera ut varianten vi inte vill använda
   // private ITransactionRepository transactionRepository = new FileTransactionRepository();
    //private ITodoRepository todoRepository = new DatabaseTodoRepository();

    // Visar exempel på hur vi hade använt TodoRepository interfacet

}
