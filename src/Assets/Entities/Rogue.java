package Assets.Entities;

import java.util.List;

import Assets.LevelUp.LevelUpAttack;
import Assets.LevelUp.LevelUpChoice;
import Assets.LevelUp.LevelUpDefense;
import Assets.LevelUp.LevelUpHealth;
import Assets.LevelUp.LevelUpSpeed;
import Assets.LevelUp.MagicLevelUp;
import Assets.LevelUp.SpeedLevelUp;
import Assets.LevelUp.StrengthLevelUp;
import Assets.Moves.*;

// Medium Attack but has the ability to ignore defense
// Medium hp and low defense
// High defense against magic
// High speed
// Starts with several special skills
public class Rogue extends Hero {
    private static final String FILE = "src/Images/Heros/rogue.png";

    public Rogue() {
        super(FILE, "Rogue", 20, 20, 20, 10, 10, 10);
        addMove(new DoubleAttack());
        setDescription("""
                <html>
                Fast hero capable of dealing large amounts of damage.
                </html>
                """);

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new StrengthLevelUp(15, 10, 5));
        levelUpChoices.add(new SpeedLevelUp(8, 2, 20));
        levelUpChoices.add(new MagicLevelUp(5));
    }

    public Entity createCopy() {
        return new Rogue();
    }
}
