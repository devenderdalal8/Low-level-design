package DigitalWallet.RepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import DigitalWallet.Entitiy.Wallet;
import DigitalWallet.Repository.WalletRepository;

public class WalletRepositoryImpl  implements WalletRepository{
    Map<String , Wallet> walletMap = new HashMap<>();

    @Override
    public Wallet findById(String id) {
        return walletMap.get(id);
    }

    @Override
    public void save(Wallet wallet) {
        walletMap.put(wallet.getWalletId(), wallet);
    }
    
}
