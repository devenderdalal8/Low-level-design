package lowLevelDesign.VendingMachine;

import lowLevelDesign.VendingMachine.entities.Inventory;
import lowLevelDesign.VendingMachine.entities.Item;
import lowLevelDesign.VendingMachine.enums.Coin;
import lowLevelDesign.VendingMachine.state.IdleDispenseState;
import lowLevelDesign.VendingMachine.state.VendingMachineState;

public class VendingMachine {

    private static final VendingMachine INSTANCE = new VendingMachine();
    private VendingMachineState vendingMachineState;
    private final Inventory inventory = new Inventory();
    private double balance = 0;
    private Item itemSelected;

    private VendingMachine() {
        vendingMachineState = new IdleDispenseState(this);
    }

    public static VendingMachine getInstance() {
        return INSTANCE;
    }

    public void addItem(String code, String name, int quantity, int price) {
        Item item = new Item(name, price, code);
        inventory.addItem(item, code, quantity);
    }

    public void insertCoin(Coin coin) {
        vendingMachineState.insertMoney(coin);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setState(VendingMachineState state) {
        vendingMachineState = state;
    }

    public void dispense() {
        vendingMachineState.dispense();
    }

    public void dispenseItem() {
        // logic to dispense item
        System.out.println("Dispensing item: " + itemSelected.getName());
        if (balance > itemSelected.getPrice()) {
            inventory.removeItem(itemSelected.getCode());
            double change = balance - itemSelected.getPrice();
            if (change > 0) {
                System.out.println("Please collect your change: " + change);
            }
        }
        reset();
        setState(new IdleDispenseState(this));
    }

    public void setSelectedItemCode(String code) {
        itemSelected = inventory.getItem(code);
    }

    public void refundMoney() {
        // logic to refund money
        vendingMachineState.refund();
        balance = 0;
    }

    public void reset() {
        itemSelected = null;
        balance = 0;
    }

    public void selectedItem(String code) {
        itemSelected = inventory.getItem(code);
        vendingMachineState.selectItem(code);
    }

    public void addBalance(int value) {
        balance = balance + value;
    }

    public Item getSelectedItem() {
        return itemSelected;
    }

    public double getBalance() {
        return balance;
    }
}
