package terrain;

import entity.Entity;
import level.Level;
import monster.Monster;
import entity.Player;
import math.Vector2i;
import scene.GameScene;

import java.io.PrintStream;
import java.nio.charset.Charset;

public class Terrain {
    private Entity[][] map;
    private int width, height;
    private GameScene gameScene;

    public Terrain(Entity[][] map, int width, int height, GameScene gameScene) {
        this.map = map;
        this.width = width;
        this.height = height;
        this.gameScene = gameScene;
    }

    public void updatePlayerPosition(Vector2i oldPosition, Vector2i newPosition) {
        try {
            Entity entity = map[newPosition.getY()][newPosition.getX()];

            if (entity instanceof Monster) {
                gameScene.shouldBattle((Monster)entity);
            }

            map[newPosition.getY()][newPosition.getX()] = Level.getPlayer();
            map[oldPosition.getY()][oldPosition.getX()] = null;
            Level.getPlayer().translate(newPosition.getX() - oldPosition.getX(), newPosition.getY() - oldPosition.getY());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Mouvement non autorisé");
        }
    }

    public Entity[][] getMap() {
        return map;
    }

    public void display() {
        try {
            Charset utf8 = Charset.forName("UTF-8");

            PrintStream printStream = new PrintStream(System.out, true, utf8.name());

            String res = "", border = "";

            for (int i = 0; i < width; i++) {
                border += "----";
            }

            border += "-\n";

            for (int i = 0; i < height; i++) {
                res += border;

                for (int j = 0; j < width; j++) {
                    res += "|" + (map[i][j] == null ? "   " : " " + map[i][j].toString() + " ");
                }

                res += "|\n";
            }

            res += border;

            printStream.println(res);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
