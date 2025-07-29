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
        super(FILE, "Wizard", 100, 100, 12, 50, 10, 10);
        addMove(new MagicAttack());
        setDescription("""
                <html>
                Average all-around in terms of stats. <br>
                Has magic skills to deal magic attacks.
                </html>
                """);

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new LevelUpHealth(20));
        levelUpChoices.add(new LevelUpDefense(10));
        levelUpChoices.add(new LevelUpMagic(40));
        levelUpChoices.add(new LevelUpSpeed(5));
    }

    public Entity createCopy() {
        return new Wizard();
    }
}
