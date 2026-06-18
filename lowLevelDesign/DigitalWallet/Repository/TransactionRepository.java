package DigitalWallet.Repository;

import java.time.LocalDateTime;
import java.util.List;

import DigitalWallet.Entitiy.Transaction;

public interface TransactionRepository {
    void save(Transaction transaction);

    List<Transaction> getTransaction(String walletId);

    List<Transaction> getTransactionHistory(String walletId, LocalDateTime from, LocalDateTime to);
}
