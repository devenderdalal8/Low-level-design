package DigitalWallet;

import DigitalWallet.Entitiy.Wallet;
import DigitalWallet.PaymentStratergy.PaymentStratergy;
import DigitalWallet.PaymentStratergy.WalletPayment;
import DigitalWallet.Repository.TransactionRepository;
import DigitalWallet.Repository.WalletRepository;
import DigitalWallet.RepositoryImpl.TransactionRepositoryImpl;
import DigitalWallet.RepositoryImpl.WalletRepositoryImpl;
import DigitalWallet.Service.WalletService;
import DigitalWallet.ServiceImpl.WalletServiceImpl;

public class MobikwikWallet {
    public static void main(String[] args) {
        WalletRepository walletRepository = new WalletRepositoryImpl();
        TransactionRepository transactionRepository = new TransactionRepositoryImpl();
        WalletService walletService = new WalletServiceImpl(transactionRepository, walletRepository);

        walletRepository.save(new Wallet("W1"));
        walletRepository.save(new Wallet("W2"));
        PaymentStratergy paymentStratergy = new WalletPayment();

        walletService.addMoney(1000, "W1", paymentStratergy);
        walletService.addMoney(1000, "W2", paymentStratergy);
        walletService.transferMoney(300,"W1","W2");
        
         System.out.println(
                walletService.getBalance("W1")); //700

        System.out.println(
                walletService.getBalance("W2")); //300
    }
}
