package entity;

import armor.Armor;
import inventory.Inventory;
import math.Vector2i;
import playerClass.PlayerClass;
import potion.HealthPotion;
import weapon.Weapon;

import static main.Consts.HEIGHT;

public class Player extends Character {
    private int xp = 0, money = 10000;
    private PlayerClass playerClass;
    private Inventory inventory = new Inventory();

    public Player(float health, int x, int y, float damage, PlayerClass playerClass) {
        super("\uD83D\uDEB6", new Vector2i(x, y), health + playerClass.getBonusHealth(),
                damage + playerClass.getBonusDamage());
        this.playerClass = playerClass;
    }

    public void resetPosition() {
        setPosition(new Vector2i(0, HEIGHT - 1));
    }

    public void updateXP(int earnedXp) {
        damage += (float)earnedXp / 100;
        health += (float)earnedXp / 100;

        xp += earnedXp;
    }

    public void updateMoney(int earnedMoney) {
        money += earnedMoney;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return inventory.getEquipedWeapon();
    }

    public Armor getArmor() {
        return inventory.getEquipedArmor();
    }

    @Override
    public float getHealth() {
        return super.health + (getArmor() == null ?  0 : getArmor().getAddedHealth());
    }

    @Override
    public boolean isDead() {
        return this.getHealth() <= 0;
    }

    @Override
    public float getDamage() {
        return super.getDamage() + (getWeapon() == null ? 0 : getWeapon().getDamage());
    }


    public int getXp() {
        return xp;
    }

    public int getMoney() {
        return money;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void buyArmor(Armor armor) {
        System.out.println("Vous avez acheté " + armor);
        money -= armor.getPrice();
        inventory.addArmor(armor);
    }

    public void buyWeapon(Weapon weapon) {
        System.out.println("Vous avez acheté " + weapon);
        money -= weapon.getPrice();
        inventory.addWeapon(weapon);
    }

    public void buyHealthPotion(HealthPotion healthPotion) {
        System.out.println("Vous avez acheté " + healthPotion);
        money -= healthPotion.getPrice();
        health = getCONST_HEALTH();
    }
}
