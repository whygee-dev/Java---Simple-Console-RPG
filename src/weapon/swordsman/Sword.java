package weapon.swordsman;

import weapon.Weapon;

public class Sword extends Weapon {
    public Sword() {
        super(120f, 200, "Sword");
    }

    @Override
    public void displayArt() {
        System.out.println("" +
                "                          ( ((\n" +
                "                           ) ))\n" +
                "  .::.                    / /(\n" +
                " 'M .-;-.-.-.-.-.-.-.-.-/| ((::::::::::::::::::::::::::::::::::::::::::::::.._\n" +
                "(J ( ( ( ( ( ( ( ( ( ( ( |  ))   -====================================-      _.>\n" +
                " `P `-;-`-`-`-`-`-`-`-`-\\| ((::::::::::::::::::::::::::::::::::::::::::::::''\n" +
                "  `::'                    \\ \\(\n" +
                "                           ) ))\n" +
                "                          (_((");
    }
}
