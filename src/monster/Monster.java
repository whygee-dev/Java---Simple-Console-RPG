package monster;

import entity.Character;
import math.Vector2i;

public abstract class Monster extends Character {
    public Monster(String name, Vector2i position, float health, float damage) {
        super(name, position, health, damage);
    }

    public String toString() {
        return " ";
    }

    public String getName() {
        return super.name;
    }

    public abstract void displayArt();

}
