import command.*;

public class Main {
    public static void main(String[] args) {

        TerminalCommandService commandService = new TerminalCommandService();
        commandService.registerCommand(new AddTransaction());
        commandService.registerCommand(new DeleteTransaction());
        commandService.registerCommand(new SeeBalance());
        commandService.registerCommand(new SeeTransactionHistory());
        commandService.registerCommand(new LoadTransactionFromFile());
        commandService.registerCommand(new SaveTransactionsToFile());
        commandService.registerCommand(new FilterTransactions());

        //if (commandService instanceof TerminalCommandService service) {
        commandService.start();
    }
}
//}