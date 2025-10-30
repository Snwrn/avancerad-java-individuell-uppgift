package service;

import models.Transaction;
import repositories.FileTransactionRepository;
import repositories.ITransactionRepository;

import java.util.ArrayList;

// Vi skulle även kunna göra TodoService till ett interface för att
// kunna återanvända den, och göra den mer flexibel, lik CommandService
public class TransactionService {
    public static final ITransactionRepository repository = new FileTransactionRepository();
    public static ArrayList<Transaction> transactions = new ArrayList<>();
    // Vi kan enkelt byta implementation genom att
    // kommentera ut varianten vi inte vill använda
   // private ITransactionRepository transactionRepository = new FileTransactionRepository();
    //private ITodoRepository todoRepository = new DatabaseTodoRepository();

    // Visar exempel på hur vi hade använt TodoRepository interfacet

}
