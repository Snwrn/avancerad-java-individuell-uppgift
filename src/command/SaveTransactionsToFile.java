package command;

public class SaveTransactionsToFile extends Command{
    public SaveTransactionsToFile() {
        super("Save transactions", "Save transaction history to a file.");
    }

    @Override
    public void execute() {
        System.out.println("Save transactions");
        backToMenu();
    }
}
