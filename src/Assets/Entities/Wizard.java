package Assets.Entities;

import java.util.List;

import Assets.LevelUp.*;
import Assets.Moves.*;

// Low attack but able to attack with magic
// Medium hp and low defense
// High defense against magic
// Medium speed
// Starts with special skills based in magic
public class Wizard extends Hero {
    private static final String FILE = "src/Images/Heros/wizard.png";

    public Wizard() {
        super(FILE, "Wizard", 20, 20, 10, 30, 10, 10);
        addMove(new MagicAttack());
        setDescription("""
                <html>
                Average all-around in terms of stats. <br>
                Has magic skills to deal magic attacks.
                </html>
                """);

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new StrengthLevelUp(5, 10, 5));
        levelUpChoices.add(new SpeedLevelUp(5, 2, 5));
        levelUpChoices.add(new WizardLevelUp(15, 2, 5));
    }

    public Entity createCopy() {
        return new Wizard();
    }
}
