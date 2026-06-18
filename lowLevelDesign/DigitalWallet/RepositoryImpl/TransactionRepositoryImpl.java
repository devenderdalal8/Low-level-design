package DigitalWallet.RepositoryImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import DigitalWallet.Entitiy.Transaction;
import DigitalWallet.Repository.TransactionRepository;

public class TransactionRepositoryImpl implements TransactionRepository {
    Map<String, List<Transaction>> transactionMap = new HashMap<>();

    @Override
    public void save(Transaction transaction) {
        transactionMap.computeIfAbsent(transaction.fromWalletId, k -> new ArrayList<>()).add(transaction);
        transactionMap.computeIfAbsent(transaction.toWalletId, k -> new ArrayList<>()).add(transaction);
    }

    @Override
    public List<Transaction> getTransaction(String walletId) {
        return transactionMap.get(walletId);
    }

    @Override
    public List<Transaction> getTransactionHistory(String walletId, LocalDateTime from, LocalDateTime to) {
        return transactionMap.get(walletId).stream()
                .filter(txn -> txn.createAt.isBefore(from) && txn.createAt.isAfter(to))
                .toList();
    }

}
