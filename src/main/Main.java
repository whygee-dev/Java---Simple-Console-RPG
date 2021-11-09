package main;

import scene.GameScene;
import scene.MenuScene;

public class Main {
    public static void main(String[] args) {
        MenuScene menuScene = new MenuScene();

        GameScene gameScene = new GameScene();
        gameScene.update();
        gameScene.gameLoop();

    }
}
