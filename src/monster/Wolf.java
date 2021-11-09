package monster;

import math.Vector2i;

public class Wolf extends Monster{
    public Wolf(Vector2i position) {
        super("Wolf", position, 175f, 150f);
    }

    @Override
    public void displayArt() {
        System.out.println("" +
                "                         ,     ,\n" +
                "                        |\\---/|\n" +
                "                       /  , , |          HP:" + getHealth() +"\n" +
                "                  __.-'|  / \\ /         Attaque:" + getDamage() + "\n" +
                "         __ ___.-'        ._O|\n" +
                "      .-'  '        :      _/\n" +
                "     / ,    .        .     |\n" +
                "    :  ;    :        :   _/\n" +
                "    |  |   .'     __:   /\n" +
                "    |  :   /'----'| \\  |\n" +
                "    \\  |\\  |      | /| |\n" +
                "     '.'| /       || \\ |\n" +
                "     | /|.'       '.l \\\\_\n" +
                "     || ||             '-'\n" +
                "     '-''-'");
    }
}
