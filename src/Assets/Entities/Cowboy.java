package Assets.Entities;

import java.util.List;

import Assets.LevelUp.LevelUpChoice;
import Assets.LevelUp.MagicLevelUp;
import Assets.LevelUp.SpeedLevelUp;
import Assets.LevelUp.StrengthLevelUp;

public class Cowboy extends Hero {
    
    private static final String FILE = "src/Images/Heros/cowboy.png";

    public Cowboy() {
        super(FILE, "Cowboy", 100, 100, 70, 20, 60, 50);
        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new StrengthLevelUp(15, 10, 10));
        levelUpChoices.add(new SpeedLevelUp(10, 5, 30));
        levelUpChoices.add(new MagicLevelUp(5));

    }

    public Entity createCopy() {
        return new Cowboy();
    }
}
