package command;
import utility.ScannerHelper;

import java.util.Scanner;

public abstract class Command {
    // Dessa är final för att de aldrig ändras
    private static int nextId = 1;
    protected final String name;
    protected final String description;
    private final int idNumber;

   public Command(String name, String description) {
        this.name = name;
        this.description = description;
        this.idNumber=nextId++;
    }

    // En metod för att exekvera kommandot
    // Den är abstract för att alla kommandon
    // fungerar olika och behöver sina egna funktioner
    // För att tvinga klasserna att implementera den är den 'abstract'
    // Alla kommando klasser overridar den
    public abstract void execute();

    public void backToMenu() {
            System.out.print("Going back to menu");
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(800); // wait 0.8 second between dots
                    System.out.print(".");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // good practice
            }
            System.out.println();
            System.out.println();// move to new line after dots
    }

    Scanner scanner = ScannerHelper.getScanner();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIdNumber() {
        return idNumber;
    }
    @Override
    public String toString() {
        return idNumber + ". " + name + " - " + description;
    }

}
