package generator;

import entity.Destination;
import entity.Entity;
import level.Level;
import monster.*;
import entity.Player;
import math.Vector2i;
import scene.GameScene;
import terrain.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static level.Level.getPlayer;
import static main.Consts.*;

public class Generators {
    public static Entity[][] generateTerrain(int width, int height, Player player,
                                             Destination destination, int monsterCount, int[] monsterIds) {
        Entity[][] res = new Entity[height][width];
        res[player.getPosition().getY()][player.getPosition().getX()] = player;
        res[0][width - 1] = destination;

        for (int i = 0; i < monsterCount; i++) {
            int randomX;
            int randomY;

            do {
                randomX = randomInt(0, width);
                randomY = randomInt(0, height);
            } while (res[randomY][randomX] != null);


            int randomMonster = randomInt(monsterIds[0], monsterIds[1] + 1);

            switch (randomMonster) {
                case SKELETON_ID:
                    res[randomY][randomX] = new Skeleton(new Vector2i(randomX, randomY));
                    break;
                case PHOENIX_ID:_ID:
                    res[randomY][randomX] = new Phoenix(new Vector2i(randomX, randomY));
                    break;
                case WOLF_ID:
                    res[randomY][randomX] = new Wolf(new Vector2i(randomX, randomY));
                    break;
                case REAPER_ID:
                    res[randomY][randomX] = new Reaper(new Vector2i(randomX, randomY));
                    break;
                case CENTAUR_ID:
                    res[randomY][randomX] = new Centaur(new Vector2i(randomX, randomY));
                    break;
                case UNICORN_ID:
                    res[randomY][randomX] = new Unicorn(new Vector2i(randomX, randomY));
                    break;
                case DRAGON_ID:
                    res[randomY][randomX] = new Dragon(new Vector2i(randomX, randomY));
                    break;
                case DEVIL_ID:
                    res[randomY][randomX] = new Devil(new Vector2i(randomX, randomY));
                    break;

            }
        }


        return res;

    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static List<Level> generateLevels(GameScene gameScene) {
        List<Level> res = new ArrayList<>();
        var destination =  new Destination(WIDTH - 1, 0);

        var level1Monsters = new int[]{0, 1};
        var terrain1 = new Terrain(
                Generators.generateTerrain(WIDTH, HEIGHT, getPlayer(), destination, 15, level1Monsters),
                WIDTH, HEIGHT, gameScene);
        var level1 = new Level(level1Monsters, terrain1);

        var level2Monsters = new int[]{2, 3};
        var terrain2 = new Terrain(
                Generators.generateTerrain(WIDTH, HEIGHT, getPlayer(), destination, 15, level2Monsters),
                WIDTH, HEIGHT, gameScene);
        var level2 = new Level(level2Monsters, terrain2);


        var level3Monsters = new int[]{4, 5};
        var terrain3 = new Terrain(
                Generators.generateTerrain(WIDTH, HEIGHT, getPlayer(), destination, 15, level3Monsters),
                WIDTH, HEIGHT, gameScene);
        var level3 = new Level(level3Monsters, terrain3);


        var level4Monsters = new int[]{6, 7};
        var terrain4 = new Terrain(
                Generators.generateTerrain(WIDTH, HEIGHT, getPlayer(), destination, 15, level4Monsters),
                WIDTH, HEIGHT, gameScene);
        var level4 = new Level(level4Monsters, terrain4);

        res.add(level1);
        res.add(level2);
        res.add(level3);
        res.add(level4);


        return res;
    }
}
