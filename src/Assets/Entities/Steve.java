package Assets.Entities;

import java.util.List;

import Assets.LevelUp.*;
import Assets.Moves.*;

public class Steve extends Hero {
    private static final String FILE = "src/Images/Heros/steve.png";

    public Steve() {
        super(FILE, "Steve", 200, 200, 20, 180, 80, 80);
        addMove(new MagicAttack());

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new StrengthLevelUp(15, 20, 20));
        levelUpChoices.add(new SpeedLevelUp(10, 5, 10));
        levelUpChoices.add(new MagicLevelUp(30));
        
    }

    public Entity createCopy() {
        return new Steve();
    }
}
