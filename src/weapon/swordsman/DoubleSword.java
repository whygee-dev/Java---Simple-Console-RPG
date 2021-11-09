package weapon.swordsman;

import weapon.Weapon;

public class DoubleSword extends Weapon {
    public DoubleSword() {
        super(160, 400, "DoubleSword");
    }

    @Override
    public void displayArt() {
        System.out.println(" " +
                "E%                                                                :\"5\n" +
                "z  %                                                              :\" `\n" +
                "K   \":                                                           z   R\n" +
                "?     %.                                                       :^    J\n" +
                " \".    ^s                                                     f     :~\n" +
                "  '+.    #L                                                 z\"    .*\n" +
                "    '+     %L                                             z\"    .~\n" +
                "      \":    '%.                                         .#     +\n" +
                "        \":    ^%.                                     .#`    +\"\n" +
                "          #:    \"n                                  .+`   .z\"\n" +
                "            #:    \":                               z`    +\"\n" +
                "              %:   `*L                           z\"    z\"\n" +
                "                *:   ^*L                       z*   .+\"\n" +
                "                  \"s   ^*L                   z#   .*\"\n" +
                "                    #s   ^%L               z#   .*\"\n" +
                "                      #s   ^%L           z#   .r\"\n" +
                "                        #s   ^%.       u#   .r\"\n" +
                "                          #i   '%.   u#   .@\"\n" +
                "                            #s   ^%u#   .@\"\n" +
                "                              #s x#   .*\"\n" +
                "                               x#`  .@%.\n" +
                "                             x#`  .d\"  \"%.\n" +
                "                           xf~  .r\" #s   \"%.\n" +
                "                     u   x*`  .r\"     #s   \"%.  x.\n" +
                "                     %Mu*`  x*\"         #m.  \"%zX\"\n" +
                "                     :R(h x*              \"h..*dN.\n" +
                "                   u@NM5e#>                 7?dMRMh.\n" +
                "                 z$@M@$#\"#\"                 *\"\"*@MM$hL\n" +
                "               u@@MM8*                          \"*$M@Mh.\n" +
                "             z$RRM8F\"                             \"N8@M$bL\n" +
                "            5`RM$#                                  'R88f)R\n" +
                "            'h.$\"                                     #$x*");
    }
}
