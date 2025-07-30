package Assets.LevelUp;

public class WizardLevelUp extends LevelUpChoice {
    

    public WizardLevelUp(int magic, int defense, int hp) {
        super("Improve Magic");

        addStat("magic", magic);
        addStat("defense", defense);
        addStat("health", hp);
        addStat("maxHealth", hp);
    }

    public LevelUpChoice createCopy() {
        return new WizardLevelUp(getStats().get("magic"), getStats().get("defense"), getStats().get("health"));
    }
}
