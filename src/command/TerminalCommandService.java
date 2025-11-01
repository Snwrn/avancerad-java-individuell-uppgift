package command;

import utility.ScannerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalCommandService implements ICommandService {

    private final List<Command> commands = new ArrayList<>();


    public void start() {
        System.out.println("=== APPLICATION ===");
        Scanner scanner = ScannerHelper.getScanner();
        while (true) {
            System.out.println("Choose a command:");

            for (Command command : commands) {
                System.out.println(command);
            }
            System.out.println((commands.size() + 1) + ". Exit");

            int choice = -1;

            while (choice < 1 || choice > (commands.size() + 1)) {
                System.out.print("Enter your choice: ");
                String commandInput = scanner.nextLine();

                Integer validatedInput = utility.InputHelper.validateNumericInput(commandInput);

                if (validatedInput == null) {
                    continue;
                }
                choice = validatedInput;

                if (choice < 1 || choice > (commands.size() + 1)) {
                    System.out.println("Invalid number. Please choose between 1 and " + (commands.size() + 1) + ".");
                }
            }

            try {
                executeCommand(choice);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void exit() {
        System.out.println("Do you want to save your transactions to a file before exiting? (yes/no)");
        Scanner scanner = utility.ScannerHelper.getScanner();
        String doYouWantToSave = scanner.nextLine();
        if (doYouWantToSave.equalsIgnoreCase("yes")) {
            //run save function
            new SaveTransactionsToFile().execute();
            System.exit(0);
        } else if (doYouWantToSave.equalsIgnoreCase("no")) {
            System.out.println("Exiting program without saving...");
            System.exit(0);
        } else {
            System.out.println("Invalid input. Please type 'yes' or 'no'.");
        }
    }

    @Override
    public void registerCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public void executeCommand(int choice) {
        for (Command command : commands) {
            if (command.getIdNumber() == choice) {
                command.execute();
                return;
            }
        }
        if (choice == (commands.size() + 1)) {
            exit();
        }
    }
}
