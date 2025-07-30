package Assets.LevelUp;

public class StrengthLevelUp extends LevelUpChoice {
    
    public StrengthLevelUp(int attack, int health, int defense) {
        super("Improve Strength");
        addStat("attack", attack);
        addStat("health", health);
        addStat("maxHealth", health);
        addStat("defense", defense);

    }

    public LevelUpChoice createCopy() {
        return new StrengthLevelUp(getStats().get("attack"), getStats().get("health"), getStats().get("defense"));
    }
}
