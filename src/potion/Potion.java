package potion;

import shop.Buyable;

public class Potion extends Buyable {
    public String name;

    public Potion(String name, int price) {
        super(price);
        this.name = name;
    }

    public String toString() {
        return name;
    }

}
