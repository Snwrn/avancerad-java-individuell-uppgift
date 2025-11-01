package command;

public class SeeTransactionHistory extends Command {
    public SeeTransactionHistory() {
        super("Transaction history", "See Transaction History");
    }

    @Override
    public void execute() {
        printTransactionSummary();
        backToMenu();
    }
}