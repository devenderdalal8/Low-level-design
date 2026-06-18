package DigitalWallet.Repository;

import DigitalWallet.Entitiy.Wallet;

public interface WalletRepository {
    Wallet findById(String id);
    void save(Wallet wallet);
}
