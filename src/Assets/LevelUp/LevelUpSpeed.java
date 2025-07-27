package Assets.LevelUp;

public class LevelUpSpeed extends LevelUpChoice {
    

    public LevelUpSpeed(int speed) {
        super("Improve speed");

        addStat("speed", speed);
    }

    public LevelUpChoice createCopy() {
        return new LevelUpSpeed(getStats().get("speed"));
    }
}
