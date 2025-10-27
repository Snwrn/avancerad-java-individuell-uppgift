package command;

import repository.FileTransactionRepository;
import repository.ITransactionRepository;

public class LoadTransactionFromFile extends Command {

    public LoadTransactionFromFile() {
        super("Load transactions", "Load transaction history from a file.");
    }

    @Override
    public void execute() {
        ITransactionRepository transactionRepository = new FileTransactionRepository();
        transactionRepository.load();
        backToMenu();
    }
}
