package Assets.LevelUp;

public class LevelUpHealth extends LevelUpChoice {
    
    public LevelUpHealth(int health) {
        super("Improve health");

        addStat("health", health);
        addStat("maxHealth", health);
    }

    public LevelUpChoice createCopy() {
        return new LevelUpHealth(getStats().get("health"));
    }
}
