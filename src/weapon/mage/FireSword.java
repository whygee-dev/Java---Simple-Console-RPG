package weapon.mage;

import weapon.Weapon;

public class FireSword extends Weapon {
    public FireSword() {
        super(200, 400, "FireSword");
    }

    @Override
    public void displayArt() {
        System.out.println("" +
                "        )         \n" +
                "          (            \n" +
                "        '    }      \n" +
                "      (    '      \n" +
                "     '      (   \n" +
                "      )  |    ) \n" +
                "    '   /|\\    `\n" +
                "   )   / | \\  ` )   \n" +
                "  {    | | |  {   \n" +
                " }     | | |  .\n" +
                "  '    | | |    )\n" +
                " (    /| | |\\    .\n" +
                "  .  / | | | \\  (\n" +
                "}    \\ \\ | / /  .        \n" +
                " (    \\ `-' /    }\n" +
                " '    / ,-. \\    ' \n" +
                "  }  / / | \\ \\  }\n" +
                " '   \\ | | | /   } \n" +
                "  (   \\| | |/  (\n" +
                "    )  | | |  )\n" +
                "    .  | | |  '\n" +
                "       J | L\n" +
                " /|    J_|_L    |\\\n" +
                " \\ \\___/ o \\___/ /\n" +
                "  \\_____ _ _____/\n" +
                "        |-|\n" +
                "        |-|\n" +
                "        |-|\n" +
                "       ,'-'.\n" +
                "       '---'");
    }
}
