package command;


public class AddTransaction extends Command {
    public AddTransaction() {
        super("Add a new transaction", "Add a new deposit or withdrawal.");
    }

    @Override
    public void execute() {
        System.out.println("Add");
        backToMenu();
    }
}
