package DigitalWallet.Service;

import DigitalWallet.PaymentStratergy.PaymentStratergy;

public interface WalletService {
    void addMoney(double amount , String walletId, PaymentStratergy paymentStratergy);
    void withdrawMoney(double amount , String walletId);
    void transferMoney(double amount , String fromWalletId , String toWalletId);
    double getBalance(String walletId);
}
