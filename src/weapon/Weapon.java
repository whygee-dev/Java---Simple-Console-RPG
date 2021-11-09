package weapon;

import shop.Buyable;

public abstract class Weapon extends Buyable {
    private float damage;
    private String name;

    public Weapon(float damage, int price, String name) {
        super(price);
        this.damage = damage;
        this.name = name;
    }

    public abstract void displayArt();

    public float getDamage() {
        return damage;
    }

    public String toString() {
        return name;
    }
}
