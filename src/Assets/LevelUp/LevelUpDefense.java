package Assets.LevelUp;

public class LevelUpDefense extends LevelUpChoice {

    public LevelUpDefense(int defense) {
        super("Improve defense");

        addStat("defense", defense);
    }

    public LevelUpChoice createCopy() {
        return new LevelUpDefense(getStats().get("defense"));
    }
}
