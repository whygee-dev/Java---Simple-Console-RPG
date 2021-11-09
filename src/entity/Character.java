package entity;

import math.Vector2i;

public abstract class Character extends Entity implements Damageable{
    protected final float CONST_HEALTH, CONST_DAMAGE;
    protected float health, damage;

    public Character(String name, Vector2i position, float health, float damage) {
        super(name, position);
        this.health = health;
        this.damage = damage;
        CONST_DAMAGE = damage;
        CONST_HEALTH = health;
    }

    public float getHealth() {
        return health;
    }

    public float getDamage() {
        return damage;
    }

    public void takeDamage(float damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public float getCONST_HEALTH() {
        return CONST_HEALTH;
    }

    public float getCONST_DAMAGE() {
        return CONST_DAMAGE;
    }
}
