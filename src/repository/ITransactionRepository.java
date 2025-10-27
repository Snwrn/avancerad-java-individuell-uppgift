package repository;

// För att enkelt kunna byta TodoRepository, man kanske exempelvis
// vill kunna byta mellan ArrayList, Fil och Databas, skapar vi ett interface
// för todorepository. Den definierar alla funktionalitet som ALLA
// todorepositories ska ha: save, load, delete, update.
// Det här gör det enkelt att byta implementation senare om man skulle vilja det.
// Det bidrar också till abstraction och encapsulation.
public interface ITransactionRepository {

    void save();
    void load();
    //void delete();
    //void update();

}