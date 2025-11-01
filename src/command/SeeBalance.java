package command;

public class SeeBalance extends Command {
    public SeeBalance() {
        super("See Balance", "See the total balance.");
    }

    @Override
    public void execute() {
        String currentBalance = utility.DoubleFormatHelper.formatDouble(service.TransactionService.getCurrentBalance());
        System.out.println("Your current balance: " + currentBalance);
        backToMenu();
    }
}
