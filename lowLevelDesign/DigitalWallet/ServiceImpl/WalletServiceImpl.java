package DigitalWallet.ServiceImpl;

import javax.management.RuntimeErrorException;

import DigitalWallet.Entitiy.Transaction;
import DigitalWallet.Entitiy.TransactionStatus;
import DigitalWallet.Entitiy.Wallet;
import DigitalWallet.PaymentStratergy.PaymentStratergy;
import DigitalWallet.Repository.TransactionRepository;
import DigitalWallet.Repository.WalletRepository;
import DigitalWallet.Service.WalletService;

public class WalletServiceImpl implements WalletService {

    private TransactionRepository transactionRepository;
    private WalletRepository walletRepository;

    public WalletServiceImpl(TransactionRepository transactionRepository, WalletRepository walletRepository) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public void addMoney(double amount, String walletId, PaymentStratergy paymentStratergy) {
        // find walletid 
        // update balance
        // save transaction
        paymentStratergy.pay(amount);
        Wallet wallet = walletRepository.findById(walletId);
        if(wallet == null){
            throw new RuntimeException("Wallet not found");
        }else{
            wallet.credit(amount);
            walletRepository.save(wallet);
        }
        
    }

    @Override
    public void withdrawMoney(double amount, String walletId) {
        // find walletid 
        // update balance
        // save transaction
        Wallet wallet = walletRepository.findById(walletId);
        if(wallet == null){
            throw new RuntimeException("Wallet not found");
        }else{
            wallet.debit(amount);
            walletRepository.save(wallet);
        }
    }

    @Override
    public void transferMoney(double amount, String fromWalletId, String toWalletId) {
        // find walletid 
        // update balance
        // save transaction
        Wallet sender = walletRepository.findById(fromWalletId);
        Wallet receiver = walletRepository.findById(toWalletId);

        Transaction transaction = new Transaction(fromWalletId, toWalletId , amount , TransactionStatus.PENDING);
        if(sender == null || receiver == null){
            transaction.setStutus(TransactionStatus.FAILED);
            throw new RuntimeException("Wallet not found");
        }

        sender.credit(amount);
        receiver.debit(amount);
        
        //save wallet
        walletRepository.save(receiver);
        walletRepository.save(sender);
        transaction.setStutus(TransactionStatus.SUCCESS);
        transactionRepository.save(transaction);
    }

    @Override
    public double getBalance(String walletId) {
        Wallet wallet = walletRepository.findById(walletId);
        return wallet.getBalance();
    }

    
}
