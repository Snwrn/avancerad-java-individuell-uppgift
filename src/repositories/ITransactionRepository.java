package repositories;

import models.Transaction;

import java.util.List;
import java.util.UUID;

// För att enkelt kunna byta TodoRepository, man kanske exempelvis
// vill kunna byta mellan ArrayList, Fil och Databas, skapar vi ett interface
// för todorepository. Den definierar alla funktionalitet som ALLA
// todorepositories ska ha: save, load, delete, update.
// Det här gör det enkelt att byta implementation senare om man skulle vilja det.
// Det bidrar också till abstraction och encapsulation.
public interface ITransactionRepository {
    void saveTransactions(List<Transaction> transactions) throws Exception;
    List<Transaction> loadTransactions() throws Exception;
}
