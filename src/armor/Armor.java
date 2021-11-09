package armor;

import shop.Buyable;

public abstract class Armor extends Buyable {
    private float addedHealth;
    private String name;

    public Armor(float addedHealth, int price, String name) {
        super(price);
        this.addedHealth = addedHealth;
        this.name = name;
    }

    public float getAddedHealth() {
        return addedHealth;
    }


    public String toString() {
        return name;
    }
}
