import command.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ICommandService commandService = new TerminalCommandService();
        commandService.registerCommand(new AddTransaction());
        commandService.registerCommand(new DeleteTransaction());
        commandService.registerCommand(new SeeBalance());
        commandService.registerCommand(new SeeTransactionHistory());
        commandService.registerCommand(new LoadTransactionFromFile());
        commandService.registerCommand(new SaveTransactionsToFile());
        commandService.registerCommand(new FilterTransactions());

        //Special start command for terminal command service
        if (commandService instanceof TerminalCommandService service){
            service.start();
        }
        }
}