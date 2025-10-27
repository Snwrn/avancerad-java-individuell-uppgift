package command;

// För att enkelt kunna byta CommandService, man kanske exempelvis
// vill kunna byta mellan terminal, gui och webb, skapar vi ett interface
// för command service. Den definierar alla funktionalitet som ALLA
// command services ska ha: start, registerCommand och executeCommand.
// Det här gör det enkelt att byta implementation senare om man skulle vilja det.
// Det bidrar också till abstraction och encapsulation.
public interface ICommandService {

    void registerCommand(Command command);
    void executeCommand(int choice);

}