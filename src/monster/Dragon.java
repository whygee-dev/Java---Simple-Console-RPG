package monster;

import math.Vector2i;

public class Dragon extends Monster{
    public Dragon(Vector2i position) {
        super("Dragon", position, 500f, 300f);
    }

    @Override
    public void displayArt() {
        System.out.println("                   ______________                               \n" +
                "                        ,===:'.,            `-._                           \n" +
                "                             `:.`---.__         `-._             HP:" + getHealth() + "          \n" +
                "                               `:.     `--.         `.           Attaque:"+getDamage() +"          \n" +
                "                                 \\.        `.         `.                   \n" +
                "                         (,,(,    \\.         `.   ____,-`.,                \n" +
                "                      (,'     `/   \\.   ,--.___`.'                         \n" +
                "                  ,  ,'  ,--.  `,   \\.;'         `                         \n" +
                "                   `{D, {    \\  :    \\;                                    \n" +
                "                     V,,'    /  /    //                                    \n" +
                "                     j;;    /  ,' ,-//.    ,---.      ,                    \n" +
                "                     \\;'   /  ,' /  _  \\  /  _  \\   ,'/                    \n" +
                "                           \\   `'  / \\  `'  / \\  `.' /                     \n" +
                "                            `.___,'   `.__,'   `.__,'");
    }
}
