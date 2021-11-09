package inventory;

import armor.Armor;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;


public class Inventory {
    List<Weapon> weapons = new ArrayList<>();
    List<Armor> armors = new ArrayList<>();
    private Weapon equipedWeapon = null;
    private Armor equipedArmor = null;


    public Inventory() { }

    public void addWeapon(Weapon weapon) {
        if (weapons.size() + armors.size() > 9) {
            System.out.println("Inventaire saturé, l'objet n'a pas été ajouté à l'inventaire.");
            return;
        }
        if (weapon == null) return;
        weapons.add(weapon);
    }

    public void addArmor(Armor armor) {
        if (weapons.size() + armors.size() > 9) {
            System.out.println("Inventaire saturé, l'objet n'a pas été ajouté à l'inventaire.");
            return;
        }

        if (armor == null) return;
        armors.add(armor);
    }

    public String toString() {
        String res = "Votre inventaire:"
                + "\n\nWeapons:" + (weapons.size() == 0 ? "aucun" : "") + "\n" ;
        int i = 1;

        for (Weapon weapon: weapons) {
            res += "W" + i + " - " + weapon + "\n";
            i++;
        }

        res += "Armors:" + (armors.size() == 0 ? "aucun" : "") + "\n";

        i = 1;

        for (Armor armor: armors) {
            res += "A"+ i + " - " + armor + "\n";
            i++;
        }

        res += "Q - Quitter";

        return res;
    }

    public boolean select(String input) {
        if (input.length() < 2) return false;

        if (input.charAt(0) == 'A' || input.charAt(0) == 'a') {
            equipedArmor = armors.get(Character.getNumericValue(input.charAt(1) - 1));
            System.out.println("Vous avez selectionné " + equipedArmor);

            return true;
        }

        if (input.charAt(0) == 'W' || input.charAt(0) == 'w') {
            equipedWeapon = weapons.get(Character.getNumericValue(input.charAt(1) - 1));
            System.out.println("Vous avez selectionné " + equipedWeapon);
            return true;
        }

        return false;
    }

    public Weapon getEquipedWeapon() {
        return equipedWeapon;
    }

    public Armor getEquipedArmor() {
        return equipedArmor;
    }
}
