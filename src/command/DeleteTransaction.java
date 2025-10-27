package command;


public class DeleteTransaction extends Command {
    public DeleteTransaction() {
        super("Delete a transaction", "Remove a transactions from the logs, restore balance.");
    }

    @Override
    public void execute() {
        System.out.println("Delete");
        backToMenu();
        }
}
