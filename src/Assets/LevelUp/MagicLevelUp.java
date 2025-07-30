package Assets.LevelUp;

public class MagicLevelUp extends LevelUpChoice {
    

    public MagicLevelUp(int magic) {
        super("Improve Magic");
        addStat("magic", magic);
    }

    public LevelUpChoice createCopy() {
        return new MagicLevelUp(getStats().get("magic"));
    }
}
