package scene;

import entity.Destination;

import generator.Generators;
import input.PlayerControl;
import level.Level;
import math.Vector2i;
import monster.Monster;
import shop.Shop;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static level.Level.getPlayer;
import static main.Consts.*;

public class GameScene{
    private Destination destination =  new Destination(WIDTH - 1, 0);
    private List<Level> levels;
    private Level currentLevel;
    private boolean ended = false, inBattle = false, isChoosingFightOrFlight = false, isInventoryOpen = false,
            isShopOpen = false;
    private Monster currentFoe = null;
    private int currentFoeFlightSuccessRate = -1;
    private Shop shop = new Shop();

    public GameScene() {
        levels = Generators.generateLevels(this);
        currentLevel = levels.remove(0);
    }

    public boolean hasEnded() {
        return ended;
    }

    public void gameLoop() {
        new PlayerControl(this).listen();
    }

    public void update() {
        if (!inBattle && !isChoosingFightOrFlight) currentLevel.getTerrain().display();
        if (getPlayer().getPosition().equals(destination.getPosition())){
            if (levels.size() == 0) win();
            else {
                currentLevel = levels.remove(0);
                getPlayer().resetPosition();
                currentLevel.getTerrain().display();
                System.out.println("Niveau " + currentLevel.getId());
            }
        }
        if (getPlayer().getHealth() <= 0) gameOver();
    }

    public void shouldBattle(Monster monster) {
        isChoosingFightOrFlight = true;
        monster.displayArt();
        currentFoe = monster;
        fightOrFlight(monster);

    }

    public void fight() {
        isChoosingFightOrFlight = false;
        inBattle = true;

        if (currentFoe == null || getPlayer() == null) {
            System.err.println("CurrentFoe or Player is null");
            System.exit(-1);
        }

        int turn = 0;

        while (!getPlayer().isDead() && !currentFoe.isDead()) {
            if (turn % 2 == 0) {
                var damage = calculateDealtDamage();
                currentFoe.takeDamage(damage);
                if (getPlayer().getWeapon() != null) {
                    getPlayer().getWeapon().displayArt();
                }
                System.out.println("Vous avez infligé " + damage + " dégats à "+ currentFoe.getName() + "\n");

                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                currentFoe.displayArt();
            } else {
                var damage = calculateDealtDamage(currentFoe);
                getPlayer().takeDamage(damage);
                System.out.println(currentFoe.getName() + " vous a infligé " + damage + " dégâts");
                displayMyStats();
            }

            turn++;

            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        inBattle = false;

        if (!getPlayer().isDead()) {
            System.out.println("Vous avez vaincu " + currentFoe.getName());
            getPlayer().updateMoney((int) currentFoe.getCONST_HEALTH() / 10);
            getPlayer().updateXP((int) currentFoe.getCONST_HEALTH());
            displayMyStats();
        }

        update();
    }

    public void flight() {
        isChoosingFightOrFlight = false;
        inBattle = false;

        if (currentFoeFlightSuccessRate == -1) return;

        if (Math.random() < (float)currentFoeFlightSuccessRate / 100) {
            System.out.println("Vous vous êtes enfui avec succés");
        } else {
            System.out.println("Vous avez subit des dégât en tentant de vous enfuire");
            getPlayer().takeDamage(currentFoe.getDamage() / 5);
            displayMyStats();
        }
        update();
    }

    public void playerUp() {
        Vector2i oldPosition = getPlayer().getPosition();
        currentLevel.getTerrain().updatePlayerPosition(oldPosition, new Vector2i(oldPosition.getX(), oldPosition.getY() - 1));
        update();
    }

    public void playerDown() {
        Vector2i oldPosition = getPlayer().getPosition();
        currentLevel.getTerrain().updatePlayerPosition(oldPosition, new Vector2i(oldPosition.getX(), oldPosition.getY() + 1));
        update();
    }

    public void playerRight() {
        Vector2i oldPosition = getPlayer().getPosition();
        currentLevel.getTerrain().updatePlayerPosition(oldPosition, new Vector2i(oldPosition.getX() + 1, oldPosition.getY()));
        update();
    }

    public void playerLeft() {
        Vector2i oldPosition = getPlayer().getPosition();
        currentLevel.getTerrain().updatePlayerPosition(oldPosition, new Vector2i(oldPosition.getX() - 1, oldPosition.getY()));
        update();
    }

    public void win() {
        ended = true;
        System.out.println("Félicitations vous avez gagné!");
    }

    public void gameOver() {
        ended = true;
        System.out.println("Vous êtes mort :(");
    }

    public void fightOrFlight(Monster monster) {
        currentFoeFlightSuccessRate = calculateFlightSuccessRate(monster);
        displayMyStats();
        System.out.println("\nA - Combattre");
        System.out.println("B - S'enfuir(" + currentFoeFlightSuccessRate +"% chance de réussite)");
    }

    public void displayMyStats() {
        System.out.println("\nVotre HP: " + getPlayer().getHealth());
        System.out.println("Votre puissance d'attaque: " + getPlayer().getDamage());
        System.out.println("Votre argent: " + getPlayer().getMoney());
        System.out.println("Votre XP:" + getPlayer().getXp());
    }

    public boolean isInBattle() {
        return inBattle;
    }

    public boolean isChoosingFightOrFlight() {
        return isChoosingFightOrFlight;
    }

    private int calculateFlightSuccessRate(Monster monster) {
        return (int)(Math.min((getPlayer().getHealth() / monster.getHealth()) *
                    (getPlayer().getDamage() / monster.getDamage()) , 0.7) * 100);
    }

    public int calculateDealtDamage() {
        return Generators.randomInt((int)(getPlayer().getDamage() / 2), (int) getPlayer().getDamage());
    }

    public int calculateDealtDamage(Monster monster) {
        return Generators.randomInt((int)(monster.getDamage() / 2), (int)monster.getDamage());
    }

    public void openInventory() {
        isInventoryOpen = true;

        System.out.println(getPlayer().getInventory());
    }

    public boolean isInventoryOpen() {
        return isInventoryOpen;
    }

    public boolean selectFromInventory(String input) {
        if (input.startsWith("q")) {
            isInventoryOpen = false;
            update();
            return true;
        }

        return getPlayer().getInventory().select(input);
    }

    public boolean selectFromShop(String input) {
        if (input.startsWith("q")) {
            isShopOpen = false;
            update();
            return true;
        }

        if (input.startsWith("a")) {
            var armor = shop.selectArmor(input);

            return armor != null;
        }

        if (input.startsWith("w")) {
            var weapon = shop.selectWeapon(input);

            return weapon != null;
        }

        if (input.startsWith("p")) {
            var potion = shop.selectPotion(input);

            return potion != null;
        }

        return false;
    }

    public void openShop() {
        isShopOpen = true;
        System.out.println(shop);
    }

    public boolean isShopOpen() {
        return isShopOpen;
    }
}
