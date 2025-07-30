package Assets.Entities;

import java.util.List;

import Assets.LevelUp.LevelUpChoice;
import Assets.LevelUp.MagicLevelUp;
import Assets.LevelUp.SpeedLevelUp;
import Assets.LevelUp.StrengthLevelUp;

public class DuckHero extends Hero {
    
    private static final String FILE = "src/Images/Enemies/duck.png";

    public DuckHero() {
        super(FILE, "Duck's Good Twin", 40, 40, 40, 20, 20, 10);
        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new StrengthLevelUp(15, 10, 10));
        levelUpChoices.add(new SpeedLevelUp(10, 5, 25));
        levelUpChoices.add(new MagicLevelUp(5));
    }

    public Entity createCopy() {
        return new DuckHero();
    }
}
