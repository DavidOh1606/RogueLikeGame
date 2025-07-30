package Assets.LevelUp;

public class SpeedLevelUp extends LevelUpChoice {

    public SpeedLevelUp(int speed, int defense, int attack) {
        super("Improve Agility");
        addStat("speed", speed);
        addStat("defense", defense);
        addStat("attack", attack);
    }

    public LevelUpChoice createCopy() {
        return new SpeedLevelUp(getStats().get("speed"), getStats().get("defense"), getStats().get("attack"));
    }
}
