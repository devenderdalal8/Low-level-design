package lowLevelDesign.VendingMachine.state;

import lowLevelDesign.VendingMachine.VendingMachine;
import lowLevelDesign.VendingMachine.enums.Coin;


public class DispenseState extends VendingMachineState {
    DispenseState(VendingMachine machine) {
        super(machine);
        System.out.println("DispenseState selected.");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing item in progress...Please wait.");
    }

    @Override
    public void insertMoney(Coin coin) {
        System.out.println("Please wait! Dispensing in progress.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void refund() {
        System.out.println("Dispensing in progress. Refund not allowed.");
    }
}
