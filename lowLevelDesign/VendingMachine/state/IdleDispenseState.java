package lowLevelDesign.VendingMachine.state;

import lowLevelDesign.VendingMachine.VendingMachine;
import lowLevelDesign.VendingMachine.enums.Coin;

public class IdleDispenseState extends VendingMachineState {
    public IdleDispenseState(VendingMachine machine) {
        super(machine);
        System.out.println("IdleDispenseState selected.");
    }

    @Override
    public void dispense() {
        System.out.println("No item selected.");
    }

    @Override
    public void insertMoney(Coin amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void selectItem(String code) {
        if (!machine.getInventory().isAvailable(code)) {
            System.out.println("Item " + code + " is out of stock. Please select another item.");

        }
        machine.setSelectedItemCode(code);
        machine.setState(new ItemSelectedState(machine));
        System.out.println("Item selected : " + code + ". Please insert money.");
    }

    @Override
    public void refund() {
        System.out.println("No money to refund.");
    }
}
