package command;

public class FilterTransactions extends Command {
    public FilterTransactions() {
        super("Filter transactions", "Filter transactions and see balance by year, month week or day.");
    }

    @Override
    public void execute() {
        System.out.println("Filter");
        backToMenu();
    }
}

