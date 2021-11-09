package level;

import entity.Destination;
import entity.Player;
import playerClass.Mage;
import playerClass.Swordsman;
import scene.MenuScene;
import terrain.Terrain;

import static main.Consts.*;

public class Level {
    private int[] monsterIds;
    private static Player player = null;
    private Terrain terrain;
    private int id;
    private static int GLOBAL_ID = 0;


    public Level(int[] monsterIds, Terrain terrain) {
        this.monsterIds = monsterIds;
        this.terrain = terrain;
        GLOBAL_ID ++;
        id = GLOBAL_ID;
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(100f, 0, HEIGHT - 1, 100f,
                    MenuScene.getChosenType() == "Swordsman" ? new Swordsman() : new Mage());
            return player;
        }

        return player;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public int[] getMonsterIds() {
        return monsterIds;
    }

    public int getId() {
        return id;
    }
}
