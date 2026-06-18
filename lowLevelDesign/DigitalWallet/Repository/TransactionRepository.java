package DigitalWallet.Repository;

import java.util.List;

import DigitalWallet.Entitiy.Transaction;

public interface TransactionRepository {
    void save(Transaction transaction);
    List<Transaction> getTransaction(String walletId);

    List<Transaction> getTransactionHistory(String walletId , long from , long to);
}   
