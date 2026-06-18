package DigitalWallet.PaymentStratergy;

public class WalletPayment implements PaymentStratergy {

    @Override
    public void pay(double amount) {
        System.out.println("Payment through Wallet");
    }

}
