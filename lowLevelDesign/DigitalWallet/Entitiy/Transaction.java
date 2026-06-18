package DigitalWallet.Entitiy;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    public String id;
    public String fromWalletId;
    public String toWalletId;
    public double amount;
    public TransactionStatus status;
    public LocalDateTime createAt;

    public Transaction(String fromWalletId, String toWalletId, double amount, TransactionStatus status) {
        this.id = UUID.randomUUID().toString();
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.amount = amount;
        this.status = status;
        this.createAt = LocalDateTime.now();
    }

    public void setStutus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", fromWalletId=" + fromWalletId + ", toWalletId=" + toWalletId + ", amount="
                + amount + ", status=" + status + ", createAt=" + createAt + "]";
    }

}
