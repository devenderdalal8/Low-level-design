package DigitalWallet.Entitiy;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    public String id;
    public String fromWalletId;
    public String toWalletId;
    public double amount;
    public TransactionStatus status;
    public Date createAt;

    public Transaction(String fromWalletId, String toWalletId, double amount, TransactionStatus status) {
        this.id = UUID.randomUUID().toString();
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.amount = amount;
        this.status = status;
        this.createAt = new Date();
    }

    public void setStutus(TransactionStatus status){
        this.status = status;
    }
}
