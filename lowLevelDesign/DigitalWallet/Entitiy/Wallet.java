package DigitalWallet.Entitiy;

public class Wallet {
    private String walletId;
    private double balance;

    public Wallet(String walletId){
        this.walletId = walletId;
        this.balance = 0;
    }

    public void credit(double amount){
        this.balance += amount;
    }

    public void debit(double amount){
        if(amount > balance){
            throw new RuntimeException("Insufficient balance");
        }else{
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getWalletId() {
        return walletId;
    }
}
