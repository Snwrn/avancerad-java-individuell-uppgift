package repositories;

import models.Transaction;

import java.util.List;

public interface ITransactionRepository {
    void saveTransactions(List<Transaction> transactions) throws Exception;
    List<Transaction> loadTransactions() throws Exception;
}
