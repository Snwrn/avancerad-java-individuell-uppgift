package command;

public class SeeBalance extends Command {
    public SeeBalance() {
        super("See Balance", "See the total balance.");
    }

    @Override
    public void execute() {
        System.out.println("see balance");
        backToMenu();
    }
}
