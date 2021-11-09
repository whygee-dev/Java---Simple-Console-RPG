package weapon.mage;

import weapon.Weapon;

public class MagicalSword extends Weapon {
    public MagicalSword() {
        super(150, 200, "MagicalSword");
    }

    @Override
    public void displayArt() {
        System.out.println("" +
                "      .m.\n" +
                "      (;)\n" +
                "      (;)\n" +
                "      (;)\n" +
                "   .  (;)  .\n" +
                "   )\\_(;)_/(\n" +
                "\n" +
                "  / / )|( \\ \\ \n" +
                "  |/ ( o ) \\|\n" +
                "      )8(\n" +
                "     ( o\\\\\n" +
                "      )8 \\\\\n" +
                "     //o|\\))\n" +
                "    //|8|\\(\n" +
                "   ((/ o||\n" +
                "    )/|8||  \n" +
                "      |o||/\\ \n" +
                "     /|8||/\\\\\n" +
                "     ||o\\/ ||\n" +
                "     |/\\   ||           \n" +
                "   /\\  ) . ||\n" +
                "  (/\\\\//||\\/|\n" +
                "  (| \\/ ||\\/\n" +
                "   \\\\   ||\n" +
                "    \\\\  ||    \n" +
                "     \\\\ //\n" +
                "      \\V/\n" +
                "       V");
    }
}
