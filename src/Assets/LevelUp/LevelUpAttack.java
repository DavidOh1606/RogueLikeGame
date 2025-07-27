package Assets.LevelUp;

public class LevelUpAttack extends LevelUpChoice {

    public LevelUpAttack(int attack) {
        super("Improve Attack");

        addStat("attack", attack);
    }

    public LevelUpChoice createCopy() {
        return new LevelUpAttack(getStats().get("attack"));
    }

}
