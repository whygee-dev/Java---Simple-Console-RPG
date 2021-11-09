package weapon.mage;

import weapon.Weapon;

public class EnchantedSword extends Weapon {
    public EnchantedSword() {
        super(100, 100, "EnchantedSword");
    }

    @Override
    public void displayArt() {
        System.out.println("                     ,-.\n" +
                "                               (\"O_)\n" +
                "                              / `-/\n" +
                "                             /-. /\n" +
                "                            /   )\n" +
                "                           /   /  \n" +
                "              _           /-. /\n" +
                "             (_)\"-._     /   )\n" +
                "               \"-._ \"-'\"\"( )/    \n" +
                "                   \"-/\"-._\" `. \n" +
                "                    /     \"-.'._\n" +
                "                   /\\       /-._\"-._\n" +
                "    _,---...__    /  ) _,-\"/    \"-(_)\n" +
                "___<__(|) _   \"\"-/  / /   /\n" +
                " '  `----' \"\"-.   \\/ /   /\n" +
                "               )  ] /   /\n" +
                "       ____..-'   //   /                       )\n" +
                "   ,-\"\"      __.,'/   /   ___                 /,\n" +
                "  /    ,--\"\"/  / /   /,-\"\"   \"\"\"-.          ,'/\n" +
                " [    (    /  / /   /  ,.---,_   `._   _,-','\n" +
                "  \\    `-./  / /   /  /       `-._  \"\"\" ,-'\n" +
                "   `-._  /  / /   /_,'            \"\"--\"\n" +
                "       \"/  / /   /\"         \n" +
                "       /  / /   /\n" +
                "      /  / /   / \n" +
                "     /  |,'   /  \n" +
                "    :   /    /\n" +
                "    [  /   ,'   \n" +
                "    | /  ,'\n" +
                "    |/,-'\n" +
                "    P'");
    }
}