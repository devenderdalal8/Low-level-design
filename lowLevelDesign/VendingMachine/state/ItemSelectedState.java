package lowLevelDesign.VendingMachine.state;

import lowLevelDesign.VendingMachine.VendingMachine;
import lowLevelDesign.VendingMachine.enums.Coin;

public class ItemSelectedState extends VendingMachineState {
    public ItemSelectedState(VendingMachine machine) {
        super(machine);
        System.out.println("ItemSelectedState selected.");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert sufficient money.");
    }

    @Override
    public void insertMoney(Coin amount) {
        machine.addBalance(amount.getValue());
        System.out.println("Coin Inserted: " + amount.getValue());
        double price = machine.getSelectedItem().getPrice();
        if (machine.getBalance() >= price) {
            System.out.println("Sufficient money received.");
            machine.setState(new HasMoneyState(machine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void refund() {
        machine.reset();
        machine.setState(new IdleDispenseState(machine));
    }
}
