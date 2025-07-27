package Assets.LevelUp;

public class LevelUpMagic extends LevelUpChoice {
    

    public LevelUpMagic(int magic) {
        super("Improve magic");

        addStat("magic", magic);
    }

    public LevelUpChoice createCopy() {
        return new LevelUpMagic(getStats().get("magic"));
    }
}
