package command;

public interface ICommandService {

    void registerCommand(Command command);

    void executeCommand(int choice);

}