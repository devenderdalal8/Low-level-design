package lowLevelDesign.VendingMachine.state;

import lowLevelDesign.VendingMachine.VendingMachine;
import lowLevelDesign.VendingMachine.enums.Coin;

public class HasMoneyState extends VendingMachineState {
    HasMoneyState(VendingMachine machine) {
        super(machine);
        System.out.println("HasMoneyState selected.");
    }

    @Override
    public void insertMoney(Coin amount) {
        System.out.println("Money already inserted. Please select an item.");
    }


    @Override
    public void selectItem(String code) {
        System.out.println("Please wait! You already selected an item.");
    }

    @Override
    public void refund() {
        //refund the money
        machine.refundMoney();
        machine.reset();
        machine.setState(new IdleDispenseState(machine));
    }

    @Override
    public void dispense() {
        machine.setState(new DispenseState(machine));
        machine.dispenseItem();
    }
}
