package input;

import scene.GameScene;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayerControl {
    private GameScene gameScene;
    public PlayerControl(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public void listen() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        try {
            while (!line.equalsIgnoreCase("quit") && !gameScene.hasEnded()) {
                if(gameScene.isChoosingFightOrFlight()) {
                    line = in.readLine().toLowerCase();
                    if (line.startsWith("a")) {
                        gameScene.fight();
                    } else if (line.startsWith("b")) {
                        gameScene.flight();
                    }
                } else if(gameScene.isInventoryOpen()) {
                    do {
                        line = in.readLine().toLowerCase();

                    } while (!gameScene.selectFromInventory(line));

                } else if (gameScene.isShopOpen()){
                    do {
                        line = in.readLine().toLowerCase();

                    } while (!gameScene.selectFromShop(line));
                } else {
                    displayControlOptions();
                    line = in.readLine().toLowerCase();
                    if (line.startsWith("m")) {
                        gameScene.openShop();
                    } else if (line.startsWith("i")) {
                      gameScene.openInventory();
                    } else if (line.startsWith("z")) {
                        gameScene.playerUp();
                    } else if (line.startsWith("s")) {
                        gameScene.playerDown();
                    } else if (line.startsWith("d")) {
                        gameScene.playerRight();
                    } else if (line.startsWith("q")) {
                        gameScene.playerLeft();
                    }
                }

            }

            in.close();

        } catch(Exception e)  {
            e.printStackTrace();
        }
    }

    public void displayControlOptions() {
        System.out.println("Z - Se d??placer en avant");
        System.out.println("S - Se d??placer en arri??re");
        System.out.println("D - Se d??placer ?? droite");
        System.out.println("Q - Se d??placer ?? gauche");
        System.out.println("I - Inventaire");
        System.out.println("M - March??");
    }

}
