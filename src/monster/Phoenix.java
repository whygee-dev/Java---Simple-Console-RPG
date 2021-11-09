package monster;

import math.Vector2i;

public class Phoenix extends Monster{
    public Phoenix(Vector2i position) {
        super("Phoenix", position, 150f, 100f);
    }


    @Override
    public void displayArt() {
        System.out.println("     " +
                "                (                           )\n" +
                "          ) )( (                           ( ) )( (\n" +
                "       ( ( ( )  ) )                     ( (   (  ) )(\n" +
                "      ) )     ,,\\\\\\                     ///,,       ) (            HP:" + getHealth() +"\n" +
                "   (  ((    (\\\\\\\\//                     \\\\////)      )          Attaque:" + getDamage()+"\n" +
                "    ) )    (-(__//                       \\\\__)-)     (\n" +
                "   (((   ((-(__||                         ||__)-))    ) )\n" +
                "  ) )   ((-(-(_||           ```\\__        ||_)-)-))   ((\n" +
                "  ((   ((-(-(/(/\\\\        ''; 9.- `      //\\)\\)-)-))    )\n" +
                "   )   (-(-(/(/(/\\\\      '';;;;-\\~      //\\)\\)\\)-)-)   (   )\n" +
                "(  (   ((-(-(/(/(/\\======,:;:;:;:,======/\\)\\)\\)-)-))   )\n" +
                "    )  '(((-(/(/(/(//////:%%%%%%%:\\\\\\\\\\\\)\\)\\)\\)-)))`  ( (\n" +
                "   ((   '((-(/(/(/('uuuu:WWWWWWWWW:uuuu`)\\)\\)\\)-))`    )\n" +
                "     ))  '((-(/(/(/('|||:wwwwwwwww:|||')\\)\\)\\)-))`    ((\n" +
                "  (   ((   '((((/(/('uuu:WWWWWWWWW:uuu`)\\)\\))))`     ))\n" +
                "        ))   '':::UUUUUU:wwwwwwwww:UUUUUU:::``     ((   )\n" +
                "          ((      '''''''\\uuuuuuuu/``````         ))\n" +
                "           ))            `JJJJJJJJJ`           ((\n" +
                "             ((            LLLLLLLLLLL         ))\n" +
                "               ))         ///|||||||\\\\\\       ((\n" +
                "                 ))      (/(/(/(^)\\)\\)\\)       ((\n" +
                "                  ((                           ))\n" +
                "                    ((                       ((\n" +
                "                      ( )( ))( ( ( ) )( ) (()");
    }
}
