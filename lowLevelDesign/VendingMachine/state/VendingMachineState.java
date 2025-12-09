package lowLevelDesign.VendingMachine.state;

import lowLevelDesign.VendingMachine.VendingMachine;
import lowLevelDesign.VendingMachine.enums.Coin;

public abstract class VendingMachineState {
    VendingMachine machine;

    VendingMachineState(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void insertMoney(Coin amount);

    public abstract void selectItem(String code);

    public abstract void refund();

    public abstract void dispense();
}
