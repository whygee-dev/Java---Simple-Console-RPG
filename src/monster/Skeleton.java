package monster;

import math.Vector2i;

public class Skeleton extends Monster{
    public Skeleton(Vector2i position) {
        super("Skeleton", position, 100f, 90f);
    }

    @Override
    public void displayArt() {
        System.out.println("" +
                "      .-.\n" +
                "     (o.o)\n" +
                "      |=|       "+"HP:" + getHealth() + "\n" +
                "     __|__       " + "Attaque:" +getDamage() + "\n" +
                "   //.=|=.\\\\\n" +
                "  // .=|=. \\\\\n" +
                "  \\\\ .=|=. //\n" +
                "   \\\\(_=_)//\n" +
                "    (:| |:)\n" +
                "     || ||\n" +
                "     () ()\n" +
                "     || ||\n" +
                "     || ||\n" +
                "    ==' '==");
    }
}
