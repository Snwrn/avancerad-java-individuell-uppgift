package repository;

public class FileTransactionRepository implements ITransactionRepository {

    @Override
    public void save() {
        System.out.println("Save to file!");
    }

    @Override
    public void load() {
        System.out.println("Load from file!");
    }

}