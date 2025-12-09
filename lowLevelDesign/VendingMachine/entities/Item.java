package lowLevelDesign.VendingMachine.entities;

public class Item {
    private final String name;
    private final double price;
    private String code;

    public Item(String name, double price, String code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
