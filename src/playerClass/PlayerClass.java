package playerClass;

public abstract class PlayerClass {
    private String name;
    private float bonusHealth, bonusDamage;

    public PlayerClass(String name, float bonusDamage, float bonusHealth) {
        this.name = name;
        this.bonusDamage = bonusDamage;
        this.bonusHealth = bonusHealth;
    }

    public String getName() {
        return name;
    }

    public float getBonusHealth() {
        return bonusHealth;
    }

    public float getBonusDamage() {
        return bonusDamage;
    }
}
