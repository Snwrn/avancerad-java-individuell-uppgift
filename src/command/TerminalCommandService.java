package command;

import utility.ScannerHelper;
import utility.numberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// En terminal-implementation av command service interfacet.
// Den hanterar kommandon genom en array list och Scanner (terminal)
public class TerminalCommandService implements ICommandService {

    private final List<Command> commands=new ArrayList<>();


    public void start() {
        System.out.println("=== APPLICATION ===");
        Scanner scanner = ScannerHelper.getScanner();
        while (true) {
            System.out.println("Choose a command:");
         /*   for (int i = 0; i < commands.size(); i++) {
                Command command = commands.get(i);
                System.out.println(command.getIdNumber() + ". " + command.getName() + " - " + command.getDescription());
            }
            */
            for(Command command : commands){
                System.out.println(command);
            }
            System.out.println((commands.size() + 1) + ". Exit");
            System.out.println("Enter your choice: ");
            String commandInput = scanner.nextLine();
            int choice = 0;
            if (null != utility.InputHelper.validateNumericInput(commandInput)) {
                choice = utility.InputHelper.validateNumericInput(commandInput);
                if (choice == (commands.size() + 1)) {

                    //put exit func here
                    System.out.println("Exiting...");
                    return;
                }
                else if (choice < 1 || choice > commands.size()) {
                    System.out.println("Invalid choice. Try again.");
                    continue;
                }

            }

            try {
                executeCommand(choice);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    // "Registrerar" ett kommando i servicen, så att den finns
    // och kan användas av användaren
    @Override
    public void registerCommand(Command command) {
        this.commands.add(command);
    }

    // Letar efter rätt kommando att exekvera baserat på user-input
    // Den använder listan som registreras med 'registerCommand'
    @Override
    public void executeCommand(int choice) {
        for (Command command : commands) {
            if (command.getIdNumber() == choice) {
                command.execute();
                return;
            }
        }
       }
}
