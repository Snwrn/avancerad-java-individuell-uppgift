package service;

import repository.FileTransactionRepository;
import repository.ITransactionRepository;

// Vi skulle även kunna göra TodoService till ett interface för att
// kunna återanvända den, och göra den mer flexibel, lik CommandService
public class TransactionService {

    // Vi kan enkelt byta implementation genom att
    // kommentera ut varianten vi inte vill använda
    private ITransactionRepository transactionRepository = new FileTransactionRepository();
    //private ITodoRepository todoRepository = new DatabaseTodoRepository();

    // Visar exempel på hur vi hade använt TodoRepository interfacet
    public void saveTransaction() {
        transactionRepository.save();
    }
}
