package shop;

import armor.Armor;
import armor.mage.LightArmor;
import armor.mage.MagicArmor;
import armor.swordsman.DiamondArmor;
import armor.swordsman.IronArmor;
import level.Level;
import potion.HealthPotion;
import potion.Potion;
import weapon.Weapon;
import weapon.mage.EnchantedKnife;
import weapon.mage.EnchantedSword;
import weapon.mage.FireSword;
import weapon.mage.MagicalSword;
import weapon.swordsman.Axe;
import weapon.swordsman.DoubleSword;
import weapon.swordsman.Knife;
import weapon.swordsman.Sword;

public class Shop {
    Knife knife = new Knife();
    Axe axe = new Axe();
    Sword sword = new Sword();
    DoubleSword doubleSword = new DoubleSword();

    IronArmor ironArmor = new IronArmor();
    DiamondArmor diamondArmor = new DiamondArmor();

    EnchantedKnife enchantedKnife = new EnchantedKnife();
    EnchantedSword enchantedSword = new EnchantedSword();
    FireSword fireSword = new FireSword();
    MagicalSword magicalSword = new MagicalSword();

    LightArmor lightArmor = new LightArmor();
    MagicArmor magicArmor = new MagicArmor();

    HealthPotion healthPotion = new HealthPotion();

    private boolean isSwordsman = Level.getPlayer().getPlayerClass().getName() == "Swordsman";

    public Shop() {

    }

    public String toString() {
        String res = "Marché \n\nVotre argent: " + Level.getPlayer().getMoney() + "\nWeapons: \n";

        if (isSwordsman) {

            res += "W1 - Knife | Prix: " + knife.getPrice() + " | Attaque: " + knife.getDamage() + "\n";
            res += "W2 - Axe | Prix: " + axe.getPrice() + " | Attaque: " + axe.getDamage() + "\n";
            res += "W3 - Sword | Prix: " + sword.getPrice() + " | Attaque: " + sword.getDamage()  + "\n";
            res += "W4 - DoubleSword | Prix: " + doubleSword.getPrice() + " | Attaque: " + doubleSword.getDamage()  + "\n";

            res += "Armors:\n";

            res += "A1 - IronArmor | Prix: " + ironArmor.getPrice() + " | Défense: " + ironArmor.getAddedHealth() + "\n";
            res += "A2 - DiamondArmor | Prix: " + diamondArmor.getPrice() + " | Défense: " + diamondArmor.getAddedHealth() + "\n";

            res += "Potions:\n";
            res += "P1 - HealthPotion | Prix: " +healthPotion.getPrice() + " | Effect: Resititue totalement le HP (effet immédiat)\n";

            res += "Q - Quitter";
            return res;


        } else {

            res += "W1 - EnchantedKnife | Prix: " + enchantedKnife.getPrice() + " | Attaque: " + enchantedKnife.getDamage()  + "\n";
            res += "W2 - EnchantedSword | Prix: " + enchantedSword.getPrice() + " | Attaque: " + enchantedSword.getDamage() + "\n";
            res += "W3 - MagicalSword | Prix: " + magicalSword.getPrice() + " | Attaque: " + magicalSword.getDamage() + "\n";
            res += "W4 - FireSword | Prix: " + fireSword.getPrice() + " | Attaque: " + fireSword.getDamage()+ "\n";

            res += "Armors:\n";


            res += "A1 - LightArmor | Prix: " + lightArmor.getPrice() + " | Défense: " + lightArmor.getAddedHealth()+ "\n";
            res += "A2 - MagicArmor | Prix: " + magicArmor.getPrice() + " | Défense: " + magicArmor.getAddedHealth()+ "\n";

            res += "Potions:\n";
            res += "P1 - HealthPotion | Prix: " +healthPotion.getPrice() + " | Effect: Resititue totalement le HP(effet immédiat)\n";

            res += "Q - Quitter\n";
            return res;
        }

    }

    public Potion selectPotion(String input) {
        if (input.length() < 2) {
            System.out.println("Mauvaise entrée");
            return null;
        }

        if (input.charAt(0) == 'P' || input.charAt(0) == 'p') {
            if (Level.getPlayer().getMoney() >= healthPotion.getPrice()) {
                Level.getPlayer().buyHealthPotion(healthPotion);
                return healthPotion;
            } else {
                System.out.println("Argent insuffisant");
                return null;
            }
        }

        return null;

    }

    public Weapon selectWeapon(String input) {
        if (input.length() < 2) {
            System.out.println("Mauvaise entrée");
            return null;
        }

        if (input.charAt(0) == 'W' || input.charAt(0) == 'w') {
            Weapon res = switch (Character.getNumericValue(input.charAt(1))) {
                case 1 -> isSwordsman ? knife : enchantedKnife;
                case 2 -> isSwordsman ? axe : enchantedSword;
                case 3 -> isSwordsman ? sword : magicalSword;
                case 4 -> isSwordsman ? doubleSword : fireSword;
                default -> null;
            };

            if (res!= null && Level.getPlayer().getMoney() >= res.getPrice()) {
                Level.getPlayer().buyWeapon(res);
                return res;
            } else {
                System.out.println("Argent insuffisant");
                return null;
            }

        }

        System.out.println("Mauvaise entrée");
        return null;
    }

    public Armor selectArmor(String input) {
        if (input.length() < 2) {
            System.out.println("Mauvaise entrée");
            return null;
        }

        if (input.charAt(0) == 'A' || input.charAt(0) == 'a') {
            Armor res = null;

            switch (Character.getNumericValue(input.charAt(1))) {
                case 1:
                    res = isSwordsman ? ironArmor : lightArmor;

                    break;

                case 2:
                    res = isSwordsman ? diamondArmor : magicArmor;

                    break;
            }

            if (res!= null && Level.getPlayer().getMoney() > res.getPrice()) {
                Level.getPlayer().buyArmor(res);
                return res;
            } else {
                if (res == null) {
                    System.out.println("Mauvaise entrée");
                } else {
                    System.out.println("Argent insuffisant");
                }

                return null;
            }

        }

        System.out.println("Mauvaise entrée");
        return null;
    }
}
